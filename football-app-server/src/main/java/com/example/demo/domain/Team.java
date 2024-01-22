package com.example.demo.domain;


public class Team {

	private Long id;
	private String name;
	private String dettagli;
	
	
	public Team(Long id,String name,String dettagli) {
		this.id=id;
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



	public Long getId() {
		return id;
	}



}