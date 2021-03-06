package com.gdim.accepted.entities;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Match {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long matchId;
	private String description;
	/* @DateTimeFormat(pattern = "MM-dd-yyyy") */
	private String match_date;
	private String match_time;
	private String team_a;
	private String team_b;
	private String sport;
	
	@OneToMany(mappedBy="match")
	@JsonIgnore
	private List<MatchOdd> matchOdds;

	public Match() {

	}
	
	public List<MatchOdd> getMatchOdds() {
		return matchOdds;
	}

	public void setMatchOdds(List<MatchOdd> matchOdds) {
		this.matchOdds = matchOdds;
	}



	public Match(String description, String match_date, String team_a, String team_b, String sport, String match_time) {
		super();
		this.description = description;
		this.match_date = match_date; 
		this.team_a = team_a;
		this.team_b = team_b;
		this.sport = sport;
		this.match_time=match_time;
		
	}

	public long getMatchId() {
		return matchId;
	}

	public void setMatchId(long matchId) {
		this.matchId = matchId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMatch_date() {
		return match_date;
	}

	public void setMatch_date(String match_date) {
		this.match_date = match_date;
	}

	public String getTeam_a() {
		return team_a;
	}

	public void setTeam_a(String team_a) {
		this.team_a = team_a;
	}

	public String getTeam_b() {
		return team_b;
	}

	public void setTeam_b(String team_b) {
		this.team_b = team_b;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getMatch_time() {
		return match_time;
	}

	public void setMatch_time(String match_time) {
		this.match_time = match_time;
	}
	
	

}
