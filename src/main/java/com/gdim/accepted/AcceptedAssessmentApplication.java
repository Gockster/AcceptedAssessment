package com.gdim.accepted;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.gdim.accepted.dao.MatchOddRepository;
import com.gdim.accepted.dao.MatchRepository;
import com.gdim.accepted.entities.Match;
import com.gdim.accepted.entities.MatchOdd;

@SpringBootApplication
public class AcceptedAssessmentApplication {
	
	@Autowired
	MatchRepository matchRepository;
	
	@Autowired
	MatchOddRepository matchOddRepository;

	public static void main(String[] args) {
		SpringApplication.run(AcceptedAssessmentApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {

		return args -> {

			MatchOdd matchOdd1 = new MatchOdd("x", 2);
			MatchOdd matchOdd2 = new MatchOdd("x", 2);
			
			Match match1 = new Match("AEK-PAO", "1-10-2021", "AEK", "PAO", "FOOTBAL");
			Match match2 = new Match("AEK-OSFP", "1-1-2021", "AEK", "OSFP", "BASKETBALL");
			
			/*
			 * match1.addMatchOdd(matchOdd1); match2.addMatchOdd(matchOdd2);
			 * 
			 * matchOdd1.setMatch((Match) Arrays.asList(match1, match2));
			 */
			
			
			matchOddRepository.save(matchOdd1);
			matchOddRepository.save(matchOdd2);
			
			matchRepository.save(match1);
			matchRepository.save(match2);
			
			
			
			
		};
	}

}
