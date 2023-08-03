package com.example.demo.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="championship")
public class Championship implements java.io.Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_championship")
	private Long id;
	
	private String year; 
	
	@ManyToOne
	private Competition competition;
	
	@OneToMany
	private List<Daymatch> daymatches;
	

	public Championship() {}
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Competition getCompetition() {
		return competition;
	}
	public void setCompetition(Competition competition) {
		this.competition = competition;
	}
	
	public List<Daymatch> getDaymatches() {
		return daymatches;
	}
	public void setDaymatches(List<Daymatch> daymatches) {
		this.daymatches = daymatches;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
