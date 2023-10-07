package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Competition;
import com.example.demo.domain.Team;
import com.example.demo.service.CompetitionService;
import com.example.demo.service.TeamInCompetitionService;
import com.example.demo.service.TeamService;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class TeamController {
	
	private TeamService service;
	private TeamInCompetitionService compINservice;
	private CompetitionService compservice;
	
	public TeamController(TeamService service,CompetitionService compservice,TeamInCompetitionService compINservice) {
		this.service=service;
		this.compINservice=compINservice;
		this.compservice=compservice;
	}
	
	@GetMapping("team/id")
	public Team getTeamById(@PathVariable long id) {
		return service.findById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:8100")
	@GetMapping("competition/{id}/teams")
	List<Team> getTeam(@PathVariable Long id){
		Competition comp = compservice.findById(id);
		return compINservice.getAllTeamByCompetition(comp);
	}

}
