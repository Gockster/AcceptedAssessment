package com.gdim.accepted.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MatchOdd {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long matchOddId; 
	private String specifier;
	private double odd;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
			fetch = FetchType.LAZY)
	@JoinColumn(name="match_id")
	@JsonIgnore
	private Match match;
	
	public MatchOdd() {
		
	}
	
	public MatchOdd(String specifier, double odd) {
		super();
		this.specifier = specifier;
		this.odd = odd;	
	}
	
	public long getMatchOddId() {
		return matchOddId;
	}

	public void setMatchOddId(long matchOddId) {
		this.matchOddId = matchOddId;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public String getSpecifier() {
		return specifier;
	}
	public void setSpecifier(String specifier) {
		this.specifier = specifier;
	}
	public double getOdd() {
		return odd;
	}
	public void setOdd(double odd) {
		this.odd = odd;
	}
	
	

}
