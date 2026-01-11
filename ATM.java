package com.bank.atm.atm;

import java.util.Scanner;

import com.bank.atm.exception.InsufficientBalanceException;
import com.bank.atm.exception.InvalidPinException;
import com.bank.atm.model.Account;
import com.bank.atm.service.BankService;

public class ATM {

    private BankService bankService = new BankService();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n--- ATM MENU ---");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Thank you for using ATM!");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void createAccount() {
        System.out.print("Enter Account Number: ");
        long accNo = sc.nextLong();
        System.out.print("Set PIN: ");
        int pin = sc.nextInt();

        bankService.createAccount(accNo, pin);
        System.out.println("Account created successfully!");
    }

    private void login() {
        try {
            System.out.print("Enter Account Number: ");
            long accNo = sc.nextLong();
            System.out.print("Enter PIN: ");
            int pin = sc.nextInt();

            Account account = bankService.login(accNo, pin);
            System.out.println("Login successful!");
            accountMenu(account);

        } catch (InvalidPinException e) {
            System.out.println(e.getMessage());
        }
    }

    private void accountMenu(Account account) {
        while (true) {
            System.out.println("\n--- ACCOUNT MENU ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Logout");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.println("Balance: " + account.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter amount: ");
                        double dep = sc.nextDouble();
                        bankService.deposit(account, dep);
                        System.out.println("Amount deposited");
                        break;
                    case 3:
                        System.out.print("Enter amount: ");
                        double wit = sc.nextDouble();
                        bankService.withdraw(account, wit);
                        System.out.println("Amount withdrawn");
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

