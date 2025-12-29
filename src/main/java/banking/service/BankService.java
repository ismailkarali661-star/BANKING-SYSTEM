package banking.service;

import banking.model.account.Account;


public class BankService implements Transferable {

    @Override
    public void transfer(Account from, Account to, double amount) {
        if (from != null && to != null && amount > 0) {
            from.withdraw(amount);
            to.deposit(amount);
        }
    }
}
