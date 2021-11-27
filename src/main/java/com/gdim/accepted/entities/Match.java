package com.gdim.accepted.entities;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Match {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String description;
	private Date match_date;
	/* private Time match_time; */
	private String team_a;
	private String team_b;
	private String sport;
	
	public Match() {
		
	}
	
	public Match(String description, Date match_date, Time match_time, String team_a, String team_b, String sport) {
		super();
		this.description = description;
		this.match_date = match_date;
		/* this.match_time = match_time; */
		this.team_a = team_a;
		this.team_b = team_b;
		this.sport = sport;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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

	/*
	 * public Time getMatch_time() { return match_time; } public void
	 * setMatch_time(Time match_time) { this.match_time = match_time; }
	 */
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
