package com.gdim.accepted.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdim.accepted.dao.MatchRepository;
import com.gdim.accepted.entities.Match;

@Controller
@RequestMapping("/matches")
public class MatchController {
	
	@Autowired
	MatchRepository matchRepository;
	
	@GetMapping
	public String displayMatches(Model model) {
		List<Match> matches = matchRepository.findAll();
		model.addAttribute("matches", matches);
		return "matches/list-matches";
	}
	
	
	
	@GetMapping("/new")
	public String displayMatchForm(Model model) {
		Match aMatch = new Match();
		model.addAttribute("match", aMatch);
		return "matches/new-match";
	}
	
	@PostMapping("/save")
	public String createMatch(Model model, Match match) {
		matchRepository.save(match);
		
		 //use redirect to prevent duplicate submissiona
		 return "redirect:/matches/new";
	}

}
