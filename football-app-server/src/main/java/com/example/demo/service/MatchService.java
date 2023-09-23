package com.example.demo.service;

import java.util.Collection;

import com.example.demo.domain.Match;
import com.example.demo.domain.Team;

public interface MatchService {

	public Match findById(Long id);
	
	public Collection<Match> getLastmatchByTeam(Team team); 
}
