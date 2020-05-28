package com.splitbill.splitbillapp.tansaction;

import com.splitbill.splitbillapp.teamTransaction.TeamTransaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Long amount;
    private String description;

    @NotNull
    private String senderId;

    @NotNull
    private String receiverId;

    @OneToMany(mappedBy = "transaction")
    private List<TeamTransaction> teamTransactions;
}