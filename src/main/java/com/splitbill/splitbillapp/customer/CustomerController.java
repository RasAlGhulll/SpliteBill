package com.splitbill.splitbillapp.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<Customer>getCustomer(@PathVariable String id){
        return customerService.getCustomer(id);
    }

    @PostMapping(value = "/customers")
    ResponseEntity<String>addCustomer(@RequestBody Customer newCustomer){
        return customerService.addCustomer(newCustomer);
    }

    @PutMapping(value = "/customers/{id}")
    ResponseEntity<String> updateCustomer(@RequestBody Customer updatedCustomer,@PathVariable String id){
        return customerService.updateCustomer(updatedCustomer,id);
    }

    @DeleteMapping(value = "/customers/{id}")
    ResponseEntity<String> deleteCustomer(@PathVariable String id){
        return customerService.deleteCustomer(id);
    }
}

