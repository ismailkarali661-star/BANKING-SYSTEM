package banking.model.account;

/**
 * Abstract base class for all account types.
 */
public abstract class Account {

    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * Deposit money into the account.
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    /**
     * Withdraw money from the account.
     * Implemented differently by each account type.
     */
    public abstract void withdraw(double amount);
}
