package com.splitbill.splitbillapp.teamTransaction;

import com.splitbill.splitbillapp.customer.Customer;
import com.splitbill.splitbillapp.tansaction.Transaction;

import java.io.Serializable;

public class TeamTransactionId implements Serializable {

    private Transaction transaction;
    private Customer customer;

    public TeamTransactionId(Transaction transaction, Customer customer) {
        this.transaction = transaction;
        this.customer = customer;
    }
}