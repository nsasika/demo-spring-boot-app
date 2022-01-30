package com.example.demo.services;

import com.example.demo.domain.Account;
import com.example.demo.domain.Customer;
import com.example.demo.exceptions.AuthException;
import com.example.demo.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer addCustomer(Customer customer) throws AuthException;

    List<Customer> getAllCustomers() throws AuthException;

    Optional<Customer> getCustomerById(Long customerId) throws ResourceNotFoundException;

    Optional<Account> addAccount(Long customerId, Account account) throws ResourceNotFoundException;
}
