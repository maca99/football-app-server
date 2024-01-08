package com.example.demo.domain;


public class Team {

	private Long id;
	private String name;
	private String dettagli;
	private String image;
	
	
	public Team(Long id,String name,String dettagli,String image) {
		this.id=id;
		this.setName(name);
		this.setDettagli(dettagli);
		this.image=image;
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



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}


}