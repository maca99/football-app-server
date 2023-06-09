package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="team")
public class Team implements java.io.Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_team")
	private long  id;
	
	private String name;
	private String coach;
	
	
	public Team() {}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

}