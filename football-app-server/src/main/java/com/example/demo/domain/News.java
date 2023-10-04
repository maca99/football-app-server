package com.example.demo.domain;


import java.util.Calendar;
import java.util.Date;


public class News implements Comparable<News>{
	

	private String titolo;
	
	private String testo;
	
	private Date date;


	public News(String titolo,String testo,Date date) {
		this.setTitolo(titolo);
		this.setTesto(testo);
		this.date=date;
	}
	
	public News(String titolo,String testo) {
		this.setTitolo(titolo);
		this.setTesto(testo);
		this.setDate();
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
		
	public void setDate() {
        Calendar calendar = Calendar.getInstance();
        // Ottieni la data corrente
        this.date = calendar.getTime();
	}

	@Override
	public int compareTo(News other) {
		return this.date.compareTo(other.date);
	}
	
	
}
