package com.example.demo.services;

import com.example.demo.domain.Customer;
import com.example.demo.exceptions.AuthException;

public interface CustomerService {

    Customer validateUser(String email, String password) throws AuthException;

    Customer registerUser(String firstName, String lastName, String email, String password) throws AuthException;
}
