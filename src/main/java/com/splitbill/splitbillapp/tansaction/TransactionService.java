package com.splitbill.splitbillapp.tansaction;

import com.splitbill.splitbillapp.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Transaction> getAllTransaction(){
        List<Transaction> transactionList = new ArrayList<>();
        transactionRepository.findAll().forEach(transactionList::add);
        return transactionList;
    }

    ResponseEntity<Transaction> getTransaction(Long id){
        if(!transactionRepository.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>(transactionRepository.findById(id).get(),HttpStatus.OK);
        }
    }

    ResponseEntity<String>addTransaction(Transaction newTransaction){
        if(!customerRepository.existsById(newTransaction.getSenderId()) || !customerRepository.existsById(newTransaction.getReceiverId())){
            return new ResponseEntity<>("Invalid Request",HttpStatus.NOT_FOUND);
        }
        try{
            transactionRepository.save(newTransaction);
        }
        catch (Exception e){
            return new ResponseEntity<>("Invalid Request",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Added into the database",HttpStatus.ACCEPTED);
    }


    ResponseEntity<String>updateTransaction(Transaction updatedTransaction,Long id){
        if(!transactionRepository.existsById(id)){
            return new ResponseEntity<>("Invalid transaction id",HttpStatus.NOT_FOUND);
        }

        try{
            updatedTransaction.setId(id);
            transactionRepository.save(updatedTransaction);
        }
        catch (Exception e){
            return new ResponseEntity<>("Error",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("transaction updated",HttpStatus.ACCEPTED);
    }

    ResponseEntity<String> deleteTransaction(Long id){
        try{
            transactionRepository.deleteById(id);
        }
        catch (Exception e){
            return new ResponseEntity<>("Invalid Request",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Deleted from the database",HttpStatus.OK);
    }

    ResponseEntity<List<Transaction>> getSplitTransaction(String senderId,String receiverId){
        if(!customerRepository.existsById(senderId) || !customerRepository.existsById(receiverId)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try{
            return new ResponseEntity<>(transactionRepository.getSplitBills(senderId,receiverId),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    ResponseEntity<String> settleUp(List<Long> deleteTransactions){
        try{
            deleteTransactions.forEach((transaction) ->{
                if(transactionRepository.existsById(transaction))
                    transactionRepository.deleteById(transaction);
            });
            return new ResponseEntity<>("all expenses are settled!",HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
