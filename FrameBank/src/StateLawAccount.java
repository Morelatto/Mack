
public class StateLawAccount
        extends LawAccount {

    private String state;

    protected StateLawAccount(int accountNumber, String password, String owner, double balance, String aim, String start, String end, double admFee, String state) {
        super(accountNumber, password, owner, balance, aim, start, end, admFee);
        if (state.length() != 2) {
            System.exit(-1);
        }
        this.state = state;
    }

    private String getState() {
        return state;
    }
    
    protected int getAccountNumber() {
        return accountNumber;
    }

    protected  String getPassword() {
        return password;
    }
    @Override
    public String toString() {
        return "Número da Conta:" + super.accountNumber + " Senha:" + super.password + " Proprietário:" + super.owner + " Saldo:" + super.balance + " Objetivo: " + super.aim + " Data de Ínicio: " + super.start + " Data de Término: " + super.end + " Taxa: " + super.admFee + " Estado: " + this.getState();
    }
}
