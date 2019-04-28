
public class CityLawAccount
        extends LawAccount {

    public String city;

    protected CityLawAccount(int accountNumber, String password, String owner, double balance, String aim, String start, String end, double admFee, String city) {
        super(accountNumber, password, owner, balance, aim, start, end, admFee);
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Número da Conta:" + super.accountNumber + " Senha:" + super.password + " Proprietário:" + super.owner + " Saldo:" + super.balance + " Objetivo: " + super.aim + " Data de Ínicio: " + super.start + " Data de Término: " + super.end + " Taxa: " + super.admFee + " Cidade: " + this.getCity();
    }
    protected int getAccountNumber() {
        return accountNumber;
    }

    protected  String getPassword() {
        return password;
    }
}
