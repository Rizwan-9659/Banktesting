package com.work.Bank.Management;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    private Bank bank;
    private BankAccount account;

    @BeforeEach
    void setup() {
        bank = new Bank();
        account = new BankAccount("101", "Alice", 1000);
        bank.addAccount(account);
    }

    @Test
    void testCredit() {
        account.credit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    void testDebit() {
        account.debit(300);
        assertEquals(700, account.getBalance());
    }

    @Test
    void testDebitInsufficient() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> account.debit(2000));
        assertEquals("Insufficient balance", ex.getMessage());
    }

    @Test
    void testLoan() {
        account.takeLoan(1000);
        assertEquals(2000, account.getBalance());
        assertEquals(1000, account.getLoanAmount());
    }

    @Test
    void testRepayLoan() {
        account.takeLoan(500);
        account.repayLoan(200);
        assertEquals(300, account.getLoanAmount());
        assertEquals(1300, account.getBalance());
    }
}
