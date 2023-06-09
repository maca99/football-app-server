package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="player")
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_player")
	private Long id;
	private String name;
	private String surname;
	@ManyToOne
	private Team club;
	private int shirt_number;
	
	public Player() {}
	
	public Player(String name, String surname, Team club, Team national_team, int shirt_number) {
		this.name = name;
		this.surname = surname;
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
	
	
}