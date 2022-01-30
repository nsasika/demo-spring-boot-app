package com.example.demo.services;

import com.example.demo.domain.Account;
import com.example.demo.exceptions.AuthException;

import java.util.List;

public interface AccountService {

    List<Account> getAllAccounts() throws AuthException;
}
