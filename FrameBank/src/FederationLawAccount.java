
public class FederationLawAccount
        extends LawAccount {

    private int instance;

    protected FederationLawAccount(int accountNumber, String password, String owner, double balance, String aim, String start, String end, double admFee, int instance) {
        super(accountNumber, password, owner, balance, aim, start, end, admFee);
        if (instance > 3 || instance < 1) {
            System.exit(-1);
        }
        this.instance = instance;
    }

    private int getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "Número da Conta:" + super.accountNumber + " Senha:" + super.password + " Proprietário:" + super.owner + " Saldo:" + super.balance + " Objetivo: " + super.aim + " Data de Ínicio: " + super.start + " Data de Término: " + super.end + " Taxa: " + super.admFee + " Federação: " + this.getInstance();
    }
    protected int getAccountNumber() {
        return accountNumber;
    }

    protected  String getPassword() {
        return password;
    }
}
