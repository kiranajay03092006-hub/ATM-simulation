package com.bank.atm.model;

public class Customer {
    private int customerId;
    private String name;
    private Account account;

    public Customer(int customerId, String name, Account account) {
        this.customerId = customerId;
        this.name = name;
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }
}

