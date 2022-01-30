package com.example.demo.services.implementation;

import com.example.demo.domain.Customer;
import com.example.demo.exceptions.AuthException;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

   final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addCustomer(Customer customer) throws AuthException {
        return customerRepository.save(customer);
    }
}
