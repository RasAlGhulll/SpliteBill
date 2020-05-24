package com.splitbill.splitbillapp.tansaction;

import com.splitbill.splitbillapp.teamTransaction.TeamTransaction;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

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

    public Transaction() {
    }

    public Transaction(Long id, @NotNull Long amount, String description, @NotNull String senderId, @NotNull String receiverId, List<TeamTransaction> teamTransactions) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.teamTransactions = teamTransactions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public List<TeamTransaction> getTeamTransactions() {
        return teamTransactions;
    }

    public void setTeamTransactions(List<TeamTransaction> teamTransactions) {
        this.teamTransactions = teamTransactions;
    }
}
