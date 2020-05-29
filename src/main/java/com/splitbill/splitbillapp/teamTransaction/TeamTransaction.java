package com.splitbill.splitbillapp.teamTransaction;

import com.splitbill.splitbillapp.customer.Customer;
import com.splitbill.splitbillapp.tansaction.Transaction;
import com.splitbill.splitbillapp.team.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TeamTransaction {

    @EmbeddedId
    TeamTransactionId teamTransactionId;

    @ManyToOne
    private Team team;

    private Long amountPaid;
    private Long amonutOwes;
}

