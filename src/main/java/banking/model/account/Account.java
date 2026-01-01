package banking.model.account;

import banking.model.Transaction;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract base class for all account types.
 * Stores balance and transaction history.
 */
public abstract class Account {

    protected String accountNumber;
    protected double balance;
    // Stores all transactions related to this account
    protected List<Transaction> transactions;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    // Returns current account balance
    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
    // Deposits money and records transaction
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("DEPOSIT", amount));
        }
    }
    // Withdraws money and records transaction
    protected void recordWithdrawal(double amount) {
        // Returns transaction history
        transactions.add(new Transaction("WITHDRAW", amount));
    }

    public abstract void withdraw(double amount);
}
