package com.example.demo.domain;

import java.util.List;


public class Daymatch {
	
	

	public Daymatch(Long id,Competition competition,List<Match>mathes) {
		
		this.setId(id);
		this.setMatches(mathes);
		this.setCompetition(competition);
	}
	
	private Long id;
	
	private Competition competition;
	
	private List<Match>matches;
	
	
	
	
	public List<Match> getMatches() {
		return matches;
	}
	public void setMatches(List<Match> matchs) {
		this.matches = matchs;
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
