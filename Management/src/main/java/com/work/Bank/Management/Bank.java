package com.work.Bank.Management;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, BankAccount> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void addAccount(BankAccount account) {
        if (accounts.containsKey(account.getAccountNumber()))
            throw new IllegalArgumentException("Account number already exists!");
        accounts.put(account.getAccountNumber(), account);
    }

    public BankAccount getAccount(String accountNumber) {
        if (!accounts.containsKey(accountNumber))
            throw new IllegalArgumentException("Account not found!");
        return accounts.get(accountNumber);
    }

    public void showAllAccounts() {
        System.out.println("\n--- All Accounts ---");
        accounts.values().forEach(System.out::println);
    }
}
