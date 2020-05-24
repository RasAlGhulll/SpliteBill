package com.splitbill.splitbillapp.teamTransaction;

import com.splitbill.splitbillapp.customer.Customer;
import com.splitbill.splitbillapp.tansaction.Transaction;
import com.splitbill.splitbillapp.team.Team;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@IdClass(TeamTransactionId.class)
public class TeamTransaction {

    @Id
    @ManyToOne
    private Transaction transaction;

    @Id
    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Team team;

    private Long amountPaid;
    private Long amonutOwes;

    public TeamTransaction(){
    }

    public TeamTransaction(Transaction transaction, Customer customer, Team team, Long amountPaid, Long amonutOwes) {
        this.transaction = transaction;
        this.customer = customer;
        this.team = team;
        this.amountPaid = amountPaid;
        this.amonutOwes = amonutOwes;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Long getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Long amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Long getAmonutOwes() {
        return amonutOwes;
    }

    public void setAmonutOwes(Long amonutOwes) {
        this.amonutOwes = amonutOwes;
    }
}

