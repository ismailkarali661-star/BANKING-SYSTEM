package banking.service;

import banking.model.account.Account;

/**
 * Defines money transfer behavior between accounts.
 */
public interface Transferable {

    void transfer(Account from, Account to, double amount);
}
