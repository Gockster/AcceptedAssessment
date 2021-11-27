package com.gdim.accepted.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdim.accepted.dao.MatchOddRepository;
import com.gdim.accepted.dao.MatchRepository;
import com.gdim.accepted.entities.Match;
import com.gdim.accepted.entities.MatchOdd;

@Controller
@RequestMapping("/matches")
public class MatchController {
	
	@Autowired
	MatchOddRepository matchOddRepository;
	
	@Autowired
	MatchRepository matchRepository;
	
	@GetMapping
	public String displayMatches(Model model) {
		List<Match> matches = matchRepository.findAll();
		model.addAttribute("matches", matches);
		return "matches/list-matches";
	}
	
	@GetMapping("/new")
	public String displayMatchForm( Model model) {
		Match aMatch = new Match();
		List<MatchOdd> matchOdds = matchOddRepository.findAll();
		model.addAttribute("allMatchOdds", matchOdds);
		model.addAttribute("match", aMatch);
		return "matches/new-match";
	}
	
	@PostMapping("/save")
	public String createMatch(Match match, @RequestParam List<Long> matchOdds,Model model) {
		matchRepository.save(match);
		Iterable<MatchOdd> chosenMatchOdds = matchOddRepository.findAllById(matchOdds);
		for(MatchOdd matchOdd : chosenMatchOdds) {
			matchOdd.setMatch(match);
			matchOddRepository.save(matchOdd);
		}
		//use redirect to prevent duplicate submissions
		return "redirect:/matches/new";
	}

}
