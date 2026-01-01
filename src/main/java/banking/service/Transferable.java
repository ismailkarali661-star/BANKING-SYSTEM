package banking.service;

import banking.model.account.Account;


public interface Transferable {

    void transfer(Account from, Account to, double amount);
}
