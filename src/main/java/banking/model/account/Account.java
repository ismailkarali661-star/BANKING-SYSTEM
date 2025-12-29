package banking.model.account;

import banking.model.Transaction;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract base class for all account types.
 */
public abstract class Account {

    protected String accountNumber;
    protected double balance;
    protected List<Transaction> transactions;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("DEPOSIT", amount));
        }
    }

    protected void recordWithdrawal(double amount) {
        transactions.add(new Transaction("WITHDRAW", amount));
    }

    public abstract void withdraw(double amount);
}
