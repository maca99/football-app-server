package com.example.demo.domain;


public class Competition {
	
	
	private Long id;
	
	private String name;
	
	private String details;
	
	private String logo;

	

	public Competition(Long id,String name,String details,String logo) {
		this.setId(id);
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

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}



}
