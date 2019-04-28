
public class BankAccount {

    public  int accountNumber;
    public  String password;
    public  String owner;
    public double balance;

    protected BankAccount(int accountNumber, String password, String owner, double balance) {
        this.accountNumber = accountNumber;
        this.password = password;
        this.owner = owner;
        this.balance = balance;
    }

    

    protected void deposit(double amount) {
        balance += amount;
    }

    protected void withDraw(double amount) {
        balance -= amount;
    }

    protected double getBalance() {
        return balance;
    }

    protected int getAccountNumber() {
        return accountNumber;
    }

    protected  String getPassword() {
        return password;
    }

    protected String getOwner() {
        return owner;
    }
//    @Override
//    public String toString() {
//        return "Número da Conta:" + this.accountNumber + " Senha:" + this.password + " Proprietário:" + this.owner + " Saldo:" + this.balance;
//    }
}
