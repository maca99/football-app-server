package com.example.demo.domain;


public class Team {

	private String name;
	private String coach;
	private Competition competition;
	
	
	public Team(String name,String coach,Competition competition) {
		this.setCoach(coach);
		this.setCompetition(competition);
		this.setName(name);
	}
	

	
	public String getCoach() {
		return coach;
	}
	public void setCoach(String coach) {
		this.coach = coach;
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

}