package com.example.demo.resources;

import com.example.demo.domain.Account;
import com.example.demo.domain.Customer;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class CustomerResource {

    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Optional<Customer> getCustomerById(@PathVariable(value = "id") long customerId) throws ResourceNotFoundException {
        Optional<Customer> customer = customerService.getCustomerById(customerId);
        return customer.map(customer1 -> {
            customer1.setAccounts(customer1.getAccounts());
            return customer1;
        });
    }

    @PostMapping("/customers/{customerId}/accounts")
    public Optional<Account> addAccount(@PathVariable(value = "customerId") Long customerId, @RequestBody Account account) throws ResourceNotFoundException {
        return customerService.addAccount(customerId,account);
    }
}
