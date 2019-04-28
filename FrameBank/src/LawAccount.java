
public abstract class LawAccount
        extends BankAccount {

    protected String aim;
    protected String start, end;
    protected double admFee;

    protected LawAccount(int accountNumber, String password, String owner, double balance, String aim, String start, String end, double admFee) {
        super(accountNumber, password, owner, balance);
        this.aim = aim;
        this.start = start;
        this.end = end;
        this.admFee = admFee;
    }

    protected double getBalance() {
        return balance * (1 - admFee / 100);
    }
    protected int getAccountNumber() {
        return accountNumber;
    }

    protected  String getPassword() {
        return password;
    }
}
