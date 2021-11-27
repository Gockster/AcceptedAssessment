package com.gdim.accepted.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gdim.accepted.dao.MatchRepository;
import com.gdim.accepted.entities.Match;

@RestController
@RequestMapping("/app-api/matches")
public class MatchApiController {
	
	@Autowired
	MatchRepository matchRepository;
	
	@GetMapping
	public List<Match> getMatches(){
		return matchRepository.findAll();
	}

}
