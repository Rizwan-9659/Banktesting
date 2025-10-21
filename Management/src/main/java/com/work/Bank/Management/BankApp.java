package com.work.Bank.Management;

import java.util.Scanner;

public class BankApp {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        boolean exit = false;

        while (!exit) {
            System.out.println(YELLOW + "\n--- BANK SYSTEM MENU ---" + RESET);
            System.out.println(GREEN + "1. Create Account");
            System.out.println("2. Credit");
            System.out.println("3. Debit");
            System.out.println("4. Take Loan");
            System.out.println("5. Repay Loan");
            System.out.println("6. Check Balance");
            System.out.println("7. View Transactions");
            System.out.println("8. Show All Accounts");
            System.out.println("9. Exit" + RESET);
            System.out.print(BLUE + "Choose an option: " + RESET);

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try {
            	switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accNo1 = sc.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String accHolder = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();
                    bank.addAccount(new BankAccount(accNo1, accHolder, balance));
                    System.out.println(GREEN + "Account created successfully!" + RESET);
                    break;

                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    System.out.print("Enter Account Number: ");
                    String accNo = sc.nextLine();
                    BankAccount account = bank.getAccount(accNo);
                    double amount;
                    switch (choice) {
                        case 2:
                            System.out.print("Enter amount to credit: ");
                            amount = sc.nextDouble();
                            account.credit(amount);
                            System.out.println(GREEN + amount + " credited successfully!" + RESET);
                            break;
                        case 3:
                            System.out.print("Enter amount to debit: ");
                            amount = sc.nextDouble();
                            account.debit(amount);
                            System.out.println(GREEN + amount + " debited successfully!" + RESET);
                            break;
                        case 4:
                            System.out.print("Enter loan amount: ");
                            amount = sc.nextDouble();
                            account.takeLoan(amount);
                            System.out.println(GREEN + "Loan of " + amount + " taken!" + RESET);
                            break;
                        case 5:
                            System.out.print("Enter amount to repay loan: ");
                            amount = sc.nextDouble();
                            account.repayLoan(amount);
                            System.out.println(GREEN + amount + " repaid successfully!" + RESET);
                            break;
                        case 6:
                            System.out.println(YELLOW + "Balance: " + account.getBalance() + RESET);
                            break;
                        case 7:
                            System.out.println(YELLOW + "--- Transaction History ---" + RESET);
                            account.getTransactions().forEach(System.out::println);
                            break;
                    }
                    break;

                case 8:
                    bank.showAllAccounts();
                    break;

                case 9:
                    exit = true;
                    System.out.println(RED + "Exiting Bank System... Thank you!" + RESET);
                    break;

                default:
                    System.out.println(RED + "Invalid option!" + RESET);
                    break;
            }

            } catch (IllegalArgumentException e) {
                System.out.println(RED + "Error: " + e.getMessage() + RESET);
            }
        }

        sc.close();
    }
}
