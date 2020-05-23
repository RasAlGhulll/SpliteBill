package com.splitbill.splitbillapp.team;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeamRepository extends CrudRepository<Team, Long> {

    public List<Team> getAllByCustomersEquals(String id);
}
