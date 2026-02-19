package com.example.demo.controller;

import com.example.demo.entity.Account;
import com.example.demo.entity.Transaction;
import com.example.demo.service.ATMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atm")

@CrossOrigin // important for frontend later
public class ATMController {

    @Autowired
    private ATMService atmService;

    // 🔐 LOGIN

    @PostMapping("/login")
    public String login(@RequestBody Account request) {
        return atmService.login(request.getAccountNumber(), request.getPin());
    }

    // 💰 CHECK BALANCE
    @GetMapping("/balance")
    public double checkBalance(@RequestParam String accountNumber) {
        return atmService.checkBalance(accountNumber);
    }

    // 💵 DEPOSIT
    @PostMapping("/deposit")
    public String deposit(@RequestBody Account request) {
        return atmService.deposit(request.getAccountNumber(), request.getBalance());
    }


    // 💸 WITHDRAW
    @PostMapping("/withdraw")
    public String withdraw(@RequestBody Account request) {
        return atmService.withdraw(request.getAccountNumber(), request.getBalance());
    }


    // 📜 TRANSACTION HISTORY
    // 📜 TRANSACTION HISTORY
    @GetMapping("/transactions")
    public List<Transaction> transactions(@RequestParam String accountNumber) {
        return atmService.getTransactions(accountNumber);
    }

}
