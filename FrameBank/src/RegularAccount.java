
public class RegularAccount
        extends BankAccount {

    private double specialBalance;

    protected RegularAccount(int accountNumber, String password, String owner, Double balance, double specialBalance) {
        super(accountNumber, password, owner, balance);
        this.specialBalance = specialBalance;
    }

    protected double getBalance() {
        return balance + specialBalance;
    }
    protected int getAccountNumber() {
        return accountNumber;
    }

    protected  String getPassword() {
        return password;
    }
    

    @Override
    public String toString() {
        return "Número da Conta:" + super.accountNumber + " Senha:" + super.password + " Proprietário:" + super.owner + " Saldo:" + this.getBalance();
    }
}
