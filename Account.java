package com.bank.atm.model;

public class Account {
    private long accountNumber;
    private int pin;
    private double balance;

    public Account(long accountNumber, int pin) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = 0.0;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public boolean validatePin(int pin) {
        return this.pin == pin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}

