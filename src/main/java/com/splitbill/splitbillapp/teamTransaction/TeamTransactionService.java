package com.splitbill.splitbillapp.teamTransaction;

import com.splitbill.splitbillapp.customer.Customer;
import com.splitbill.splitbillapp.customer.CustomerRepository;
import com.splitbill.splitbillapp.tansaction.Transaction;
import com.splitbill.splitbillapp.tansaction.TransactionRepository;
import com.splitbill.splitbillapp.team.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class TeamTransactionService {

    @Autowired
    private TeamTransactionRepository teamTransactionRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    ResponseEntity<String> addTeamTransaction(Long teamId, String userId, HashMap<String,List<String> > transactionDetails){
        if(!teamRepository.existsById(teamId) || !customerRepository.existsById(userId))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(0L);
        newTransaction.setReceiverId("1");
        newTransaction.setSenderId(userId);
        newTransaction.setDescription(transactionDetails.get("description").get(0));

        transactionRepository.save(newTransaction);

        transactionDetails.remove("description");
        transactionDetails.forEach((key,value) ->{
            System.out.println(key);

            if(!customerRepository.existsById(key))
                return;

            TeamTransactionId newId = new TeamTransactionId(newTransaction,customerRepository.findById(key).get());

            TeamTransaction newTeamTransaction = new TeamTransaction();
            newTeamTransaction.setTeamTransactionId(newId);
            newTeamTransaction.setTeam(teamRepository.findById(teamId).get());
            newTeamTransaction.setAmountPaid(Long.valueOf(value.get(0)));
            newTeamTransaction.setAmonutOwes(Long.valueOf(value.get(1)));

            teamTransactionRepository.save(newTeamTransaction);
        });
        return new ResponseEntity<>("saved!",HttpStatus.OK);
    }

}
