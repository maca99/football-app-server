package com.example.demo.domain;

import java.util.List;


public class Daymatch {
	
	public Daymatch(Long id,Competition competition,List<Match>maths) {
		
		this.setId(id);
		this.setMatchs(maths);
		this.setCompetition(competition);
		
	}
	
	private Long id;
	
	private List<Match>matchs;
	
	private Competition competition;
	
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
	public Competition getCompetition() {
		return competition;
	}
	public void setCompetition(Competition competition) {
		this.competition = competition;
	}
	
}
