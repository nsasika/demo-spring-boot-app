package com.example.demo.services;

import com.example.demo.domain.Customer;
import com.example.demo.exceptions.AuthException;

import java.util.List;

public interface CustomerService {

    Customer addCustomer(Customer customer) throws AuthException;

    List<Customer> getAllCustomers() throws AuthException;
}
