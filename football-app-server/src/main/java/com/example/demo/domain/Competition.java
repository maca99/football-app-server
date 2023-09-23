package com.example.demo.domain;

import java.util.List;

public class Competition {
	
	
	private Long id;
	
	private String name;
	
	private String details;
	
	private String logo;
	
	private List<Daymatch> daymatches;
	
	private List<Team> teams;
	

	public Competition(Long id,String name,String details,String logo) {
		this.setName(name);
		this.setDetails(details);
		this.setLogo(logo);
	}
		
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}


	public List<Daymatch> getDaymatches() {
		return daymatches;
	}

	//Dato una lista la itero creando la serie delle giornate
	public void setDaymatches() {
		
	}


	public List<Team> getTeams() {
		return teams;
	}


	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}



}
