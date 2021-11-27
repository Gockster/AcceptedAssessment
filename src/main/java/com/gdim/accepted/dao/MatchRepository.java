package com.gdim.accepted.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gdim.accepted.entities.Match;

public interface MatchRepository extends CrudRepository<Match, Long> {
	
	@Override
	List<Match> findAll();

}
