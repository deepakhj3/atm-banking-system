package com.example.demo.service;


import com.example.demo.entity.Account;
import com.example.demo.entity.Transaction;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ATMService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    // 🔐 LOGIN
    private String loggedInAccount = null;


    public String login(String accountNumber, int pin) {

        Account account = accountRepository
                .findByAccountNumber(accountNumber)
                .orElse(null);

        if (account == null) {
            return "Account Not Found";
        }

        if (account.getPin() == pin) {
            loggedInAccount = accountNumber;   // ✅ store session
            return "Login Successful";
        }

        return "Invalid PIN";
    }


    // 💰 CHECK BALANCE
    public double checkBalance(String accountNumber) {

        if (loggedInAccount == null || !loggedInAccount.equals(accountNumber)) {
            throw new RuntimeException("Please login first");
        }

        Account account = accountRepository
                .findByAccountNumber(accountNumber)
                .orElse(null);

        return account.getBalance();
    }


    // 💵 DEPOSIT
    public String deposit(String accountNumber, double amount) {

        if (loggedInAccount == null || !loggedInAccount.equals(accountNumber)) {
            return "Please login first";
        }

        Account account = accountRepository
                .findByAccountNumber(accountNumber)
                .orElseThrow();

        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setAccountId(account.getId());
        transaction.setType("DEPOSIT");
        transaction.setAmount(amount);
        transactionRepository.save(transaction);

        return "Deposit Successful";
    }


    // 💸 WITHDRAW
    // 💸 WITHDRAW
    public String withdraw(String accountNumber, double amount) {

        if (loggedInAccount == null || !loggedInAccount.equals(accountNumber)) {
            return "Please login first";
        }

        Account account = accountRepository
                .findByAccountNumber(accountNumber)
                .orElseThrow();

        if (amount <= 0) {
            return "Invalid withdrawal amount";
        }

        if (amount > 100000) {
            return "Daily withdrawal limit exceeded (₹100000)";
        }

        if (amount > account.getBalance()) {
            return "Insufficient Balance";
        }

        if (account.getBalance() - amount < 100) {
            return "Minimum balance ₹100 must be maintained";
        }

        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setAccountId(account.getId());
        transaction.setType("WITHDRAW");
        transaction.setAmount(amount);
        transactionRepository.save(transaction);

        return "Withdraw Successful";
    }

    public List<Transaction> getTransactions(String accountNumber) {

        if (loggedInAccount == null || !loggedInAccount.equals(accountNumber)) {
            throw new RuntimeException("Please login first");
        }

        Account account = accountRepository
                .findByAccountNumber(accountNumber)
                .orElseThrow();

        return transactionRepository.findByAccountId(account.getId());
    }



}