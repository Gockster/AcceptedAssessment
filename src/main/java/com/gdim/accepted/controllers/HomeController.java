package com.gdim.accepted.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdim.accepted.dao.MatchOddRepository;
import com.gdim.accepted.dao.MatchRepository;
import com.gdim.accepted.entities.Match;
import com.gdim.accepted.entities.MatchOdd;

@Controller
public class HomeController {
	
	@Autowired
	MatchRepository matchRepository;
	
	@Autowired
	MatchOddRepository matchOddRepository;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		List<Match> matches = matchRepository.findAll();
		model.addAttribute("matchesList", matches);
		
		List<MatchOdd> matchOdds = matchOddRepository.findAll();
		model.addAttribute("matchOddsList", matchOdds);
		
		return "home";
	}
	
	

}
