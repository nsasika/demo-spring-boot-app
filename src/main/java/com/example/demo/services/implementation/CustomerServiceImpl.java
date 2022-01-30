package com.example.demo.services.implementation;

import com.example.demo.domain.Account;
import com.example.demo.domain.Customer;
import com.example.demo.exceptions.AuthException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    final CustomerRepository customerRepository;
    final AccountRepository accountRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public Customer addCustomer(Customer customer) throws AuthException {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() throws AuthException {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long customerId) throws ResourceNotFoundException {
        return Optional.ofNullable(customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Could not find Customer id::" + customerId)));
    }

    @Override
    public Optional<Account> addAccount(Long customerId, Account account) throws ResourceNotFoundException {
        return Optional.ofNullable(customerRepository.findById(customerId).map(customer -> {
            account.setCustomer(customer);
            return accountRepository.save(account);
        }).orElseThrow(() -> new ResourceNotFoundException("CustomerId " + customerId + " not found")));
    }
}
