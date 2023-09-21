package com.example.demo.domain;


public class Player {
	

	private Long id;
	private String name;
	private String surname;
	private Team club;
	private int shirt_number;
	
	public Player() {}
	
	public Player(String name, String surname, Team club, Team national_team, int shirt_number) {
		this.setName(name);
		this.setSurname(surname);
		this.club = club;
		this.shirt_number = shirt_number;
	}

	public Team getClub() {
		return club;
	}

	public void setClub(Team club) {
		this.club = club;
	}

	public int getShirt_number() {
		return shirt_number;
	}

	public void setShirt_number(int shirt_number) {
		this.shirt_number = shirt_number;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public void setId(Long id) {
		this.id = id;
	}
	
	
}