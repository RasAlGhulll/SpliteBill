package com.splitbill.splitbillapp.team;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.splitbill.splitbillapp.customer.Customer;
import com.splitbill.splitbillapp.teamTransaction.TeamTransaction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    private String description;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany
    private List<Customer> customers = new ArrayList<>();

    @OneToMany(mappedBy = "team")
    private List<TeamTransaction> teamTransactions;

    public Team() {
    }

    public Team(Long id, @NotNull String name, String description, List<Customer> customers, List<TeamTransaction> teamTransactions) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.customers = customers;
        this.teamTransactions = teamTransactions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<TeamTransaction> getTeamTransactions() {
        return teamTransactions;
    }

    public void setTeamTransactions(List<TeamTransaction> teamTransactions) {
        this.teamTransactions = teamTransactions;
    }
}
