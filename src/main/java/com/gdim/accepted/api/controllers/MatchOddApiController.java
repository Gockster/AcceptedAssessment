package com.gdim.accepted.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gdim.accepted.dao.MatchOddRepository;
import com.gdim.accepted.entities.Match;
import com.gdim.accepted.entities.MatchOdd;

@RestController
@RequestMapping("/app-api/matchodds")
public class MatchOddApiController {

	@Autowired
	MatchOddRepository matchOddRepository;

	@GetMapping
	public List<MatchOdd> getMatchOdds() {
		return matchOddRepository.findAll();
	}

	@GetMapping("/{id}")
	public MatchOdd getMatchOddById(@PathVariable("id") Long id) {
		return matchOddRepository.findById(id).get();
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public MatchOdd create(@RequestBody MatchOdd matchOdd) {
		return matchOddRepository.save(matchOdd);
	}

	@PutMapping(path = "/{id}", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public MatchOdd update(@RequestBody MatchOdd matchOdd) {
		return matchOddRepository.save(matchOdd);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		try {
			matchOddRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {

		}
	}

}

