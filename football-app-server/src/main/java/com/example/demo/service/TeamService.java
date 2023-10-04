package com.example.demo.service;

import java.util.Collection;

import com.example.demo.domain.Team;

public interface TeamService {
	
	public Collection<Team>getAllTeam();
		
	 public Team findById(Long id);
	 
	 public Team findByname(String name);
	 
	//public Map <Team,List<Match> > getAllPlayedMatchByCompetition(Competition comp);
	
	 
}
