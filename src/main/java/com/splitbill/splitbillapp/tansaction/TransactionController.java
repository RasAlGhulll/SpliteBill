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

    @GetMapping(value = "/transaction")
    public List<Transaction> getTransaction(){
        return transactionService.getAllTransaction();
    }

    @GetMapping(value = "/transaction/{id}")
    ResponseEntity<Transaction> getTransaction(@PathVariable Long id){
        return transactionService.getTransaction(id);
    }

    @PostMapping(value = "/transaction")
    ResponseEntity<String> addTransaction(@RequestBody Transaction newTransaction){
        return transactionService.addTransaction(newTransaction);
    }

    @PutMapping(value = "/transaction/{id}")
    ResponseEntity<String> updateTransaction(@RequestBody Transaction updatedTransaction,@PathVariable Long id){
        return transactionService.updateTransaction(updatedTransaction,id);
    }

    @DeleteMapping(value = "/transaction/{id}")
    ResponseEntity<String> deleteTransaction(@PathVariable Long id){
        return transactionService.deleteTransaction(id);
    }

    @GetMapping(value = "/transaction/sender={senderId}/receiver={receiverId}")
    ResponseEntity<List<Transaction> > getSplitTransaction(@PathVariable String senderId,@PathVariable String receiverId){
        return  transactionService.getSplitTransaction(senderId,receiverId);
    }

    @DeleteMapping(value = "/transaction")
    ResponseEntity<String> settleUp(@RequestBody List<Long> Deletetransactions){
        return transactionService.settleUp(Deletetransactions);
    }
}
