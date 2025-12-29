package banking;

import banking.model.account.CheckingAccount;
import banking.model.account.SavingsAccount;
import banking.service.BankService;

public class Main {

    public static void main(String[] args) {

        SavingsAccount savings = new SavingsAccount("SA-1001", 1000);
        CheckingAccount checking = new CheckingAccount("CA-2001", 500);

        BankService bankService = new BankService();

        savings.deposit(200);
        savings.withdraw(150);

        bankService.transfer(savings, checking, 300);

        System.out.println("Savings Balance: " + savings.getBalance());
        System.out.println("Checking Balance: " + checking.getBalance());

        System.out.println("\nSavings Transactions:");
        savings.getTransactions().forEach(t ->
                System.out.println(t.getType() + " - " + t.getAmount())
        );
    }
}
