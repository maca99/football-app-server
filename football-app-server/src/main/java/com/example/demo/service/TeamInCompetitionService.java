package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Competition;
import com.example.demo.domain.Team;

public interface TeamInCompetitionService {
	
	public List<Team> getAllTeamByCompetition(Competition comp);
	public List<Competition> getAllCompetitionByTeam(Team t);
}
