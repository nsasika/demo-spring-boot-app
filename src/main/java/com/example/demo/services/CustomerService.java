package com.example.demo.services;

import com.example.demo.domain.Customer;
import com.example.demo.exceptions.AuthException;

public interface CustomerService {

    Customer addCustomer(Customer customer) throws AuthException;
}
