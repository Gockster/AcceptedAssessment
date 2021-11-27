package com.gdim.accepted.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MatchOdd {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private long match_id;
	private String specifier;
	private double odd;
	
	public MatchOdd() {
		
	}
	
	public MatchOdd(long match_id, String specifier, double odd) {
		super();
		this.match_id = match_id;
		this.specifier = specifier;
		this.odd = odd;
	}
	public long getMatch_id() {
		return match_id;
	}
	public void setMatch_id(long match_id) {
		this.match_id = match_id;
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
