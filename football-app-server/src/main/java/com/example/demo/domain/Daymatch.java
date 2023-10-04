package com.example.demo.domain;

import java.util.List;


public class Daymatch implements Comparable<Daymatch>{
	
	

	public Daymatch(Long id,boolean last,short num,Competition competition,List<Match>maths) {
		
		this.setId(id);
		this.num=num;
		this.setMatchs(maths);
		this.setCompetition(competition);
		this.setLast(last);
	}
	
	private Long id;
	
	private short num;
	
	private boolean last;
	
	private Competition competition;
	
	private List<Match>matchs;
	
	
	
	
	public List<Match> getMatchs() {
		return matchs;
	}
	public void setMatchs(List<Match> matchs) {
		this.matchs = matchs;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Competition getCompetition() {
		return competition;
	}
	public void setCompetition(Competition competition) {
		this.competition = competition;
	}
	public boolean isLast() {
		return last;
	}
	public void setLast(boolean last) {
		this.last = last;
	}
	public short getNum() {
		return num;
	}
	public void setNum(short num) {
		this.num = num;
	}
	@Override
	public int compareTo(Daymatch d) {
		return this.num-d.getNum();
	}
}
