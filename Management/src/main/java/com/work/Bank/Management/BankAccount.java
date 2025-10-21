package com.work.Bank.Management;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private double loanAmount;
    private List<Transaction> transactions;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.loanAmount = 0.0;
        this.transactions = new ArrayList<>();
        transactions.add(new Transaction("Account Created", balance));
    }

    public void credit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Credit amount must be positive");
        balance += amount;
        transactions.add(new Transaction("Credit", amount));
    }

    public void debit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Debit amount must be positive");
        if (amount > balance) throw new IllegalArgumentException("Insufficient balance");
        balance -= amount;
        transactions.add(new Transaction("Debit", amount));
    }

    public void takeLoan(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Loan amount must be positive");
        loanAmount += amount;
        balance += amount;
        transactions.add(new Transaction("Loan Taken", amount));
    }

    public void repayLoan(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Repay amount must be positive");
        if (amount > balance) throw new IllegalArgumentException("Insufficient balance to repay loan");
        if (amount > loanAmount) throw new IllegalArgumentException("Repay amount exceeds loan balance");
        balance -= amount;
        loanAmount -= amount;
        transactions.add(new Transaction("Loan Repay", amount));
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public double getBalance() { return balance; }
    public double getLoanAmount() { return loanAmount; }
    public String getAccountHolder() { return accountHolder; }
    public String getAccountNumber() { return accountNumber; }

    @Override
    public String toString() {
        return accountNumber + " | " + accountHolder + " | Balance: " + balance + " | Loan: " + loanAmount;
    }
}
