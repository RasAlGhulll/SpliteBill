package com.splitbill.splitbillapp.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customers")
    public List<Customer> getAllcustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(value = "/customers/{id}")
    public Customer getCustomer(@PathVariable String id){
        return customerService.getCustomer(id);
    }

    @PostMapping(value = "/customers")
    public void addCustomer(@RequestBody Customer newCustomer){
        customerService.addCustomer(newCustomer);
    }

    @PutMapping(value = "/customers/{id}")
    public void updateCustomer(@RequestBody Customer updatedCustomer, String id){
        customerService.updateCustomer(updatedCustomer,id);
    }

    @DeleteMapping(value = "/customers/{id}")
    public void deleteCustomer(@PathVariable String id){
        customerService.deleteCustomer(id);
    }
}

