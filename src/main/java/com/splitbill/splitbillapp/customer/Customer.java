package com.splitbill.splitbillapp.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.splitbill.splitbillapp.team.Team;
import com.splitbill.splitbillapp.teamTransaction.TeamTransaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

    @Id
    private String id;

    @NotNull
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    private String password;

    @ManyToMany(mappedBy = "customers")
    private List<Team> teams = new ArrayList<>();

    @OneToMany(mappedBy = "customer")
    private List<TeamTransaction> teamTransactions;
}
