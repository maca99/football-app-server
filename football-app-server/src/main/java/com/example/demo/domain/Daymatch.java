package com.example.demo.domain;

import java.util.List;


public class Daymatch {
	
	public Daymatch() {}
	
	private Long id;
	
	private List<Match>matchs;
	
	public List<Match> getMatchs() {
		return matchs;
	}
	public void setMatchs(List<Match> matchs) {
		this.matchs = matchs;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
