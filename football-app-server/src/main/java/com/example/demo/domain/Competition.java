package com.example.demo.domain;

import java.util.List;

public class Competition {
	
	
	private String name;
	
	private String details;
	
	private String logo;
	
	private List<Daymatch> daymatches;
	

	public Competition(String name,String details,String logo) {
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


	public void setDaymatches(List<Daymatch> daymatches) {
		this.daymatches = daymatches;
	}



}
