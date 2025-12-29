package banking.service;

import banking.model.account.CheckingAccount;
import banking.model.account.SavingsAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankServiceTest {

    @Test
    void transfer_shouldMoveMoneyBetweenAccounts() {
        SavingsAccount savings = new SavingsAccount("SA-1", 1000);
        CheckingAccount checking = new CheckingAccount("CA-1", 500);

        BankService bankService = new BankService();
        bankService.transfer(savings, checking, 300);

        assertEquals(700, savings.getBalance());
        assertEquals(800, checking.getBalance());
    }

    @Test
    void savingsAccount_shouldNotAllowOverdraft() {
        SavingsAccount savings = new SavingsAccount("SA-2", 100);

        savings.withdraw(200);

        assertEquals(100, savings.getBalance());
    }

    @Test
    void checkingAccount_shouldAllowLimitedOverdraft() {
        CheckingAccount checking = new CheckingAccount("CA-2", 100);

        checking.withdraw(500);

        assertEquals(-400, checking.getBalance());
    }
}
