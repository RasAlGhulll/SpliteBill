package com.splitbill.splitbillapp.team;

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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany
    private List<Customer> customers = new ArrayList<>();

    @OneToMany(mappedBy = "team")
    private List<TeamTransaction> teamTransactions;
}
