package com.splitbill.splitbillapp.team;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.splitbill.splitbillapp.customer.Customer;
import com.splitbill.splitbillapp.teamTransaction.TeamTransaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    private String description;

    @JsonIgnore
    @ManyToMany
    private List<Customer> customers = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "team")
    private List<TeamTransaction> teamTransactions;
}
