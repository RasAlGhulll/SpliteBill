package com.splitbill.splitbillapp.teamTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class TeamTransactionController {

    @Autowired
    private TeamTransactionService teamTransactionService;

    @PostMapping(value = "/transactions/team={teamId}&user={userId}")
    ResponseEntity<String> addTeamTransactions(@PathVariable Long teamId, @PathVariable String userId, @RequestBody HashMap<String,List<String> > transactionDetails){
        return teamTransactionService.addTeamTransaction(teamId,userId,transactionDetails);
    }
}
