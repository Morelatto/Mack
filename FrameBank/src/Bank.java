
import java.io.*;
import java.util.ArrayList;

public final class Bank {

    public ArrayList a = new ArrayList<>();

    public Bank(String filename) {
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(filename));
            String linha = entrada.readLine();
            int ii = Integer.parseInt(linha);
            for (int i = 0; i < ii; i++) {
                linha = entrada.readLine();
                String vetString[] = linha.split("#");
                int accountNumber = Integer.parseInt(vetString[1]);
                String password = vetString[2];
                String owner = vetString[3];
                double balance = Double.parseDouble(vetString[4]);
                switch (vetString[0]) {
                    case "RA":
                        double specialBalance = Double.parseDouble(vetString[5]);
                        a.add(new RegularAccount(accountNumber, password, owner, balance, specialBalance));
                        break;
                    case "SA":
                        double interestRate = Double.parseDouble(vetString[5]);
                        a.add(new SavingsAccount(accountNumber, password, owner, balance, interestRate));
                        break;
                    case "CLA": {
                        String aim = vetString[5];
                        String start = vetString[6];
                        String end = vetString[7];
                        double admFee = Double.parseDouble(vetString[8]);
                        String city = vetString[9];
                        a.add(new CityLawAccount(accountNumber, password, owner, balance, aim, start, end, admFee, city));
                        break;
                    }
                    case "SLA": {
                        String aim = vetString[5];
                        String start = vetString[6];
                        String end = vetString[7];
                        double admFee = Double.parseDouble(vetString[8]);
                        String state = vetString[9];
                        a.add(new StateLawAccount(accountNumber, password, owner, balance, aim, start, end, admFee, state));
                        break;
                    }
                    case "FLA": {
                        String aim = vetString[5];
                        String start = vetString[6];
                        String end = vetString[7];
                        double admFee = Double.parseDouble(vetString[8]);
                        int instance = Integer.parseInt(vetString[9]);
                        a.add(new FederationLawAccount(accountNumber, password, owner, balance, aim, start, end, admFee, instance));
                        break;
                    }
                }
            }
            orderAccounts(a);
            System.out.println("\n"+h);
            /*
            DEIXE COMENTADO POR ENQUANTO
            dump(a);
            System.out.println("RegularAccounts:");
            showArray(regularAccounts());
            System.out.println("\nSavingsAccounts:");
            showArray(savingsAccounts());
            System.out.println("\nLawAccounts:");
            showArray(lawAccounts());*/
            
        } catch (IOException objeto_excecao) {
            System.out.println(objeto_excecao);
            System.exit(-1);
        }
    }

    public static void intercalacao(int p, int m, int n, ArrayList<BankAccount> v) {
        int i = p, j = m, k = 0;
        BankAccount w[] = new BankAccount[n - p];
        while (i < m && j < n) {
            if (v.get(i).getBalance() <= v.get(j).getBalance()) {
                w[k++] = v.get(i++);
            } else {
                w[k++] = v.get(j++);
            }
        }
        while (i < m) {
            w[k++] = v.get(i++);
        }
        while (j < n) {
            w[k++] = v.get(j++);
        }
        for (i = p, j = 0; i < n; i++, j++) {
            v.remove(i);
            v.add(i, w[j]);
        }
    }

    public static void mergeSort(int p, int n, ArrayList<BankAccount> v) {
        int m = (p + n) / 2;
        if (p < n - 1) {
            mergeSort(p, m, v);
            mergeSort(m, n, v);
            intercalacao(p, m, n, v);
        }
    }

    public void orderAccounts(ArrayList a) {
        int length = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) != null) {
                length++;
            }
        }
        mergeSort(0, length, a);
    }

    public void dump(ArrayList<BankAccount> a) {
        try (BufferedWriter w = new BufferedWriter(new FileWriter("saida.txt"))) {
            w.write(String.valueOf((a.size())));
            w.newLine();
            for (int i = 0; i < a.size(); i++) {
                w.write(String.valueOf(a.get(i)));
                w.newLine();
            }
            w.flush();
        } catch (Exception e) {
            System.exit(-1);
        }
    }

    public void showArray(ArrayList b) {
        for (int i = 0; i < b.size(); i++) {
            System.out.print(b.get(i) + "\n");
        }
    }

    public ArrayList<RegularAccount> regularAccounts() {
        ArrayList<RegularAccount> b = null;
        for (int i = a.size() - 1; i >= 0; i--) {
            if (a.get(i) instanceof RegularAccount) {
                if (b == null) {
                    b = new ArrayList<>();
                }
                b.add((RegularAccount) a.get(i));
            }
        }
        return b;
    }

    public ArrayList<SavingsAccount> savingsAccounts() {
        ArrayList<SavingsAccount> b = null;
        for (int i = a.size() - 1; i >= 0; i--) {
            if (a.get(i) instanceof SavingsAccount) {
                if (b == null) {
                    b = new ArrayList<>();
                }
                b.add((SavingsAccount) a.get(i));
            }
        }
        return b;
    }

    public ArrayList<LawAccount> lawAccounts() {
        ArrayList<LawAccount> b = null;
        for(int i=0;i<=a.size()-1;i++){
            if (a.get(i) instanceof CityLawAccount) {
                if (b == null) {
                b = new ArrayList<>();
                }
            
            b.add((CityLawAccount) a.get(i));
        }
        }
        for(int i=0;i<=a.size()-1;i++){
            if (a.get(i) instanceof StateLawAccount) {
                if (b == null) {
                b = new ArrayList<>();
                }
          
            b.add((StateLawAccount) a.get(i));
        }
        }
        for(int i=0;i<=a.size()-1;i++){
            if (a.get(i) instanceof FederationLawAccount) {
                if (b == null) {
                b = new ArrayList<>();
                }
            b.add((FederationLawAccount) a.get(i));
        }
        }
        return b;
    }
        public boolean verificaConta(int acc,String pass){
            boolean verifica=false;
            for (int i = 0; i < a.size(); i++) {
                //aqui deve receber a "acc" e "pass" digitados no FrameBank e verificar se tem algum igual no 
                //ArrayList, se houver, retorna true, e eu passo pra próxima tela.
                
            }
            return verifica;
        }
}

