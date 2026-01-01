package banking.model.account;


public class CheckingAccount extends Account {

    private static final double OVERDRAFT_LIMIT = 500.0;

    public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && balance - amount >= -OVERDRAFT_LIMIT) {
            balance -= amount;
            recordWithdrawal(amount);
        }
    }
}
