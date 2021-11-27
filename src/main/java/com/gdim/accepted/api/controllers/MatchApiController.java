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

import com.gdim.accepted.dao.MatchRepository;
import com.gdim.accepted.entities.Match;

@RestController
@RequestMapping("/app-api/matches")
public class MatchApiController {

	@Autowired
	MatchRepository matchRepository;

	@GetMapping
	public List<Match> getMatches() {
		return matchRepository.findAll();
	}

	@GetMapping("/{id}")
	public Match getMatchById(@PathVariable("id") Long id) {
		return matchRepository.findById(id).get();
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Match create(@RequestBody Match match) {
		return matchRepository.save(match);
	}

	@PutMapping(path = "/{id}", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Match update(@RequestBody Match match) {
		return matchRepository.save(match);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		try {
			matchRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {

		}
	}

}
