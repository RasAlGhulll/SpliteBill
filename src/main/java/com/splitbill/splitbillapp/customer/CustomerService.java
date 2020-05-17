package com.splitbill.splitbillapp.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        List<Customer> customerList= new ArrayList<>();
        customerRepository.findAll().forEach(customerList::add);
        return customerList;
    }

    public Customer getCustomer(String id){
        return customerRepository.findById(id).get();
    }

    public void addCustomer(Customer newCustomer){
        customerRepository.save(newCustomer);
    }

    public void updateCustomer(Customer updatedCustomer,String id){
        customerRepository.save(updatedCustomer);
    }

    public void deleteCustomer(String id){
        customerRepository.deleteById(id);
    }
}
