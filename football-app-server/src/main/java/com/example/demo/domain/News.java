package com.example.demo.domain;


import org.hibernate.annotations.Tables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class News{
	
	
    private @Id @GeneratedValue long id;
	

	private String titolo;
	
	private String testo;

	
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

	
	
	
}
