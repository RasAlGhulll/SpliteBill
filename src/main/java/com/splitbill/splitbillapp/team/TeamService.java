package com.splitbill.splitbillapp.team;

import com.splitbill.splitbillapp.customer.Customer;
import com.splitbill.splitbillapp.customer.CustomerRepository;
import com.splitbill.splitbillapp.customer.CustomerService;
import com.splitbill.splitbillapp.tansaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.LoggingMXBean;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private CustomerRepository customerRepository;

    ResponseEntity<List<Team> > getAllTeams(String userId){
        return new ResponseEntity<>(customerRepository.findById(userId).get().getTeams(),HttpStatus.OK);
    }

    ResponseEntity<Long> addTeam(Team newTeam, String userId){
        if(!customerRepository.existsById(userId))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try{
            teamRepository.save(newTeam);
            return new ResponseEntity<>(newTeam.getId(),HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    ResponseEntity<String> addTeamMembers(Long teamId,List<String> friends){
        if(!teamRepository.existsById(teamId)){
            return new ResponseEntity<>("group doesn't exits!",HttpStatus.BAD_REQUEST);
        }

        try{
            Team temp = teamRepository.findById(teamId).get();
            List<Customer> teammates = temp.getCustomers();

            friends.forEach((userId) ->{
                if(customerRepository.existsById(userId))
                    teammates.add(customerRepository.findById(userId).get());
            });
            temp.setCustomers(teammates);
            teamRepository.save(temp);
            return new ResponseEntity<>("memebers are added in group!",HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Something went wrong!",HttpStatus.BAD_REQUEST);
        }
    }

//    ResponseEntity<String> getTeamTransactions(Long teamId){
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
}
