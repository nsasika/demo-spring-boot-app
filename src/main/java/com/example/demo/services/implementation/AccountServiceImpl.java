package com.example.demo.services.implementation;

import com.example.demo.domain.Account;
import com.example.demo.exceptions.AuthException;
import com.example.demo.repository.AccountRepository;
import com.example.demo.services.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAllAccounts() throws AuthException {
        return accountRepository.findAll();
    }
}
