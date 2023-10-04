package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Competition;
import com.example.demo.domain.Daymatch;
import com.example.demo.domain.Match;
import com.example.demo.domain.Team;

public interface DaymatchService {
	
	public List<Daymatch> getByCompetition(Long id);
	
	public List<Match> getAllMatchByTeam(Team team);
	
	public List<Daymatch> getPlayedDayMatchByCompetition(Competition comp);
	
	public Daymatch getLastDayMatchByCompetition(Competition comp);
}
