package com.example.demo.config;

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void run(String... args) throws Exception {
        // Check if accounts already exist
        if (accountRepository.count() == 0) {
            System.out.println("📝 Creating test accounts...");

            // Create account 1001
            Account acc1 = new Account();
            acc1.setAccountNumber("1001");
            acc1.setPin(1234);
            acc1.setBalance(21900.0);
            accountRepository.save(acc1);

            // Create account 1002
            Account acc2 = new Account();
            acc2.setAccountNumber("1002");
            acc2.setPin(2222);
            acc2.setBalance(25000.0);
            accountRepository.save(acc2);

            // Create account 1003
            Account acc3 = new Account();
            acc3.setAccountNumber("1003");
            acc3.setPin(3333);
            acc3.setBalance(8000.0);
            accountRepository.save(acc3);

            System.out.println("✅ Test accounts created!");
        }
    }
}