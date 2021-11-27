package com.gdim.accepted.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gdim.accepted.entities.MatchOdd;

public interface MatchOddRepository extends CrudRepository<MatchOdd, Long>{
	
	@Override
	List<MatchOdd> findAll();

}
