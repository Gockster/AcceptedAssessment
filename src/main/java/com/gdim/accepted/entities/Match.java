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

@Entity
public class Match {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long matchId;
	private String description;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date match_date;
	private String team_a;
	private String team_b;
	private String sport;
	
	@OneToMany(mappedBy="match")
	private List<MatchOdd> matchOdds;

	public Match() {

	}
	
	public List<MatchOdd> getMatchOdds() {
		return matchOdds;
	}

	public void setMatchOdds(List<MatchOdd> matchOdds) {
		this.matchOdds = matchOdds;
	}



	public Match(String description, Date match_date, String team_a, String team_b, String sport) {
		super();
		this.description = description;
		this.match_date = match_date; 
		this.team_a = team_a;
		this.team_b = team_b;
		this.sport = sport;
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

	public Date getMatch_date() {
		return match_date;
	}

	public void setMatch_date(Date match_date) {
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

}
