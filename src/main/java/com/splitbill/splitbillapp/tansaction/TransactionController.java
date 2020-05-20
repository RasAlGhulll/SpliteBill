package com.splitbill.splitbillapp.tansaction;

import com.splitbill.splitbillapp.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = "/transcation")
    public List<Transaction> getTransaction(){
        return transactionService.getAllTransaction();
    }

    @GetMapping(value = "/transcation/{id}")
    ResponseEntity<Transaction> getTransaction(@PathVariable Long id){
        return transactionService.getTransaction(id);
    }

    @PostMapping(value = "/transcation")
    ResponseEntity<String> addTransaction(@RequestBody Transaction newTransaction){
        return transactionService.addTransaction(newTransaction);
    }

    @PutMapping(value = "/transcation/{id}")
    public void updateTranscation(@RequestBody Transaction updatedTranscation, Long id){
        transactionService.updateTransaction(updatedTranscation,id);
    }

    @DeleteMapping(value = "/transcation/{id}")
    ResponseEntity<String> deleteTranscation(@PathVariable Long id){
        return transactionService.deleteTranscation(id);
    }
}
