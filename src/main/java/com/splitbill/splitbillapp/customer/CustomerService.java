package com.splitbill.splitbillapp.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    ResponseEntity<Customer>getCustomer(String id){
        if(!customerRepository.existsById(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerRepository.findById(id).get(),HttpStatus.OK);
    }

    ResponseEntity<String>addCustomer(Customer newCustomer){
        if(customerRepository.existsById(newCustomer.getId())){
            return new ResponseEntity<>("User Already exists!!",HttpStatus.CONFLICT);
        }
        try {
            customerRepository.save(newCustomer);
        }
        catch (Exception e){
            return new ResponseEntity<>("Invalid request",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("User Created!",HttpStatus.ACCEPTED);
    }

    ResponseEntity<String> updateCustomer(Customer updatedCustomer,String id){
        if(!customerRepository.existsById(id)){
            return new ResponseEntity<>("Id doesn't exists!",HttpStatus.NOT_FOUND);
        }

        try {
            updatedCustomer.setId(id);
            customerRepository.save(updatedCustomer);
        }
        catch (Exception e){
            return new ResponseEntity<>("Invalid request",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("User data updated!",HttpStatus.ACCEPTED);
    }

    ResponseEntity<String>deleteCustomer(String id){
        try{
            customerRepository.deleteById(id);
        }
        catch (Exception e){
            return new ResponseEntity<>("Invalid Request",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("User deleted!",HttpStatus.ACCEPTED);
    }
}
