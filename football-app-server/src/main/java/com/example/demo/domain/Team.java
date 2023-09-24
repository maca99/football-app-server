package com.example.demo.domain;


public class Team {

	private Long id;
	private String name;
	private String dettagli;
	private Competition competition;
	
	
	public Team(Long id,String name,String dettagli,Competition competition) {
		this.id=id;
		this.setCompetition(competition);
		this.setName(name);
		this.setDettagli(dettagli);
	}
	

	
	public String getDettagli() {
		return dettagli;
	}
	public void setDettagli(String dettagli) {
		this.dettagli = dettagli;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



	public Competition getCompetition() {
		return competition;
	}



	public void setCompetition(Competition competition) {
		this.competition = competition;
	}



	public Long getId() {
		return id;
	}


}