package com.bank.atm.service;

import java.util.HashMap;
import java.util.Map;

import com.bank.atm.exception.InsufficientBalanceException;
import com.bank.atm.exception.InvalidPinException;
import com.bank.atm.model.Account;

public class BankService {

    private Map<Long, Account> accounts = new HashMap<>();

    public Account createAccount(long accNo, int pin) {
        Account account = new Account(accNo, pin);
        accounts.put(accNo, account);
        return account;
    }

    public Account login(long accNo, int pin) throws InvalidPinException {
        Account account = accounts.get(accNo);
        if (account == null || !account.validatePin(pin)) {
            throw new InvalidPinException("Invalid Account Number or PIN");
        }
        return account;
    }

    public void deposit(Account account, double amount) {
        if (amount > 0) {
            account.deposit(amount);
        }
    }

    public void withdraw(Account account, double amount)
            throws InsufficientBalanceException {
        if (amount > account.getBalance()) {
            throw new InsufficientBalanceException("Insufficient Balance");
        }
        account.withdraw(amount);
    }
}

