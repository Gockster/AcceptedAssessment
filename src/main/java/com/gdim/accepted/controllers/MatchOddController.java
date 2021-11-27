package com.gdim.accepted.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdim.accepted.dao.MatchOddRepository;
import com.gdim.accepted.entities.Match;
import com.gdim.accepted.entities.MatchOdd;

@Controller
@RequestMapping("/matchOdds")
public class MatchOddController {
	
	@Autowired
	MatchOddRepository matchOddRepository;
	
	@GetMapping
	public String displayMatchOdds(Model model) {
		List<MatchOdd> matchOdds = matchOddRepository.findAll();
		model.addAttribute("matchOdds", matchOdds);
		return "matchOdds/list-matchOdds";
	}
	
	@GetMapping("/new")
	public String displayMatchOddForm(Model model) {
		MatchOdd aMatchOdd = new MatchOdd();
		model.addAttribute("matchOdd", aMatchOdd);
		return "matchOdds/new-matchOdd";
	}
	
	@PostMapping("/save")
	public String createMatchOdd(Model model, MatchOdd matchOdd) {
		matchOddRepository.save(matchOdd);
		
		 //use redirect to prevent duplicate submissiona
		 return "redirect:/matchOdds/new";
	}

}
