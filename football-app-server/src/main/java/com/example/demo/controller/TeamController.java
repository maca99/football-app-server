package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Team;
import com.example.demo.service.TeamService;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class TeamController {
	
	private TeamService service;
	
	public TeamController(TeamService service) {
		this.service=service;
	}
	
	@GetMapping("team/id")
	public Team getTeamById(@PathVariable long id) {
		return service.findById(id);
	}
	

}
