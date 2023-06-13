package com.example.demo.domain;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
public class News implements Comparable<News>{
	
	
    private @Id @GeneratedValue long id;
	

	private String titolo;
	
	private String testo;
	
	 @Temporal(TemporalType.DATE)
	private Date date;

	 @PrePersist
	 public void prePersist() {
	  	date = new Date();
	 }



	public News() {}
	
	
		public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}

		public Date getDate() {
		return date;
	}
		
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int compareTo(News other) {
		return this.date.compareTo(other.date);
	}
	
	
}
