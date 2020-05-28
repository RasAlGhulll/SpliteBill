package com.splitbill.splitbillapp.teamTransaction;

import com.splitbill.splitbillapp.customer.Customer;
import com.splitbill.splitbillapp.tansaction.Transaction;
import com.splitbill.splitbillapp.team.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}

