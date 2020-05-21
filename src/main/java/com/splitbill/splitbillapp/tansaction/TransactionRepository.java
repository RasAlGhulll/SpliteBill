package com.splitbill.splitbillapp.tansaction;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    @Query("SELECT t FROM Transaction t WHERE (t.senderId = :senderId and t.receiverId = :receiverId) or (t.senderId = :receiverId and t.receiverId = :senderId)")
    public List<Transaction> getSplitBills(String senderId,String receiverId);

}
