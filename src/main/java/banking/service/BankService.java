package banking.service;

import banking.exception.InsufficientBalanceException;
import banking.model.account.Account;
/**
 * Handles money transfer operations between accounts.
 */

public class BankService implements Transferable {
    // Transfers money from one account to another
    @Override
    public void transfer(Account from, Account to, double amount) {
        // Validate accounts
        if (from == null || to == null) {
            throw new IllegalArgumentException("Accounts cannot be null");
        }
// Validate transfer amount
        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive");
        }

        double beforeBalance = from.getBalance();
        from.withdraw(amount);
        // Withdraw money from source account
        if (from.getBalance() == beforeBalance) {
            throw new InsufficientBalanceException(
                    "Insufficient balance for transfer"
            );
        }
// Deposit money to target account
        to.deposit(amount);
    }
}
