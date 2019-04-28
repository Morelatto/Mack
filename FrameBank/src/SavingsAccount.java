
public class SavingsAccount
        extends BankAccount {

    private double interestRate;

    protected SavingsAccount(int accountNumber, String password, String owner, double balance, double interestRate) {
        super(accountNumber, password, owner, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double getBalance() {
        return super.getBalance() * (1 + interestRate);
    }
    protected int getAccountNumber() {
        return accountNumber;
    }

    protected  String getPassword() {
        return password;
    }
    public double getSB(){
        return interestRate;
    }

    @Override
    public String toString() {
        return "Número da Conta:" + super.accountNumber + " Senha:" + this.password + " Proprietário:" + super.owner + " Saldo:" + getBalance() + " Taxa:" + this.interestRate;
    }
}
