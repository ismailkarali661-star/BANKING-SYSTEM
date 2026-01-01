package banking.service;

import banking.exception.InsufficientBalanceException;
import banking.model.account.Account;


public class BankService implements Transferable {

    @Override
    public void transfer(Account from, Account to, double amount) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Accounts cannot be null");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive");
        }

        double beforeBalance = from.getBalance();
        from.withdraw(amount);

        if (from.getBalance() == beforeBalance) {
            throw new InsufficientBalanceException(
                    "Insufficient balance for transfer"
            );
        }

        to.deposit(amount);
    }
}
