package com.example.demo.domain;

import java.util.Date;



public class Match {
	
	private Long id;

	private Team home;
	   
	private Team visitor;
	
	private Date date_match;
	
	private String score;
	
	private int home_score;

	private int visitor_score;
	
	public Match(Long id) {
		this.id=id;
	}

	
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


	public String getScore() {
		return score;
	}


	public void setScore(String score) {
		this.score = score;
	}
	
		
	
}