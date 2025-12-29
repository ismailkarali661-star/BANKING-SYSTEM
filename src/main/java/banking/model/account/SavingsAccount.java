package banking.model.account;

/**
 * Savings account with no overdraft allowed.
 */
public class SavingsAccount extends Account {

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            recordWithdrawal(amount);
        }
    }
}
