package com.example.demo.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="matchs")
public class Match {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_match")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_home" )
	private Team home;
	   
	@ManyToOne
	@JoinColumn(name = "id_visitor")
	private Team visitor;
	
	@Column(nullable= false,columnDefinition="boolean default false")
	private boolean terminata;
	
	private Date date_match;
	
	@Column(nullable = false, columnDefinition = "int default 0")
	private int home_score;
	@Column(nullable = false, columnDefinition = "int default 0")
	private int visitor_score;
	
	public Match() {}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setHome(Team home) {
		this.home = home;
	}
	
	public Team getHome() {
		return home;
	}
	
	public Team getVisitor() {
		return visitor;
	}


	public void setVisitor(Team visitor) {
		this.visitor = visitor;
	}


	public Date getDate() {
		return date_match;
	}


	public void setDate(Date date) {
		this.date_match = date;
	}


	public int getHome_score() {
		return home_score;
	}


	public void setHome_score() {
		this.home_score++;
	}


	public int getVisitor_score() {
		return visitor_score;
	}


	public void setVisitor_score() {
		this.visitor_score++;
	}
	
		
	
}