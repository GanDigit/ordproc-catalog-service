package com.ord.catalogservice.controller;

import com.ord.catalogservice.jpa.Customer;
import com.ord.catalogservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    private List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    private Customer getCustomer(@PathVariable("id") int id) {
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/customers/{id}")
    private void deleteCustomer(@PathVariable("id") int id) {
        customerService.delete(id);
    }

    @PostMapping("/customers")
    private int saveCustomer(@RequestBody Customer customer) {
        customerService.saveOrUpdate(customer);
        return customer.getId();
    }
}
