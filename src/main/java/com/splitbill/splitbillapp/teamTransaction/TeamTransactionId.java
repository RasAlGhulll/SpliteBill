package com.splitbill.splitbillapp.teamTransaction;

import com.splitbill.splitbillapp.customer.Customer;
import com.splitbill.splitbillapp.tansaction.Transaction;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TeamTransactionId implements Serializable {

    @ManyToOne
    private Transaction transaction;

    @ManyToOne
    private Customer customer;

    public TeamTransactionId() {
    }

    public TeamTransactionId(Transaction transaction, Customer customer) {
        this.transaction = transaction;
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamTransactionId that = (TeamTransactionId) o;
        return transaction.equals(that.transaction) &&
                customer.equals(that.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transaction, customer);
    }
}