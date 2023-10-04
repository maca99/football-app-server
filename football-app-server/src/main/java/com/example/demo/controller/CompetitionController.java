package com.example.demo.controller;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.domain.Competition;
import com.example.demo.domain.Daymatch;
import com.example.demo.domain.Match;
import com.example.demo.domain.Team;
import com.example.demo.service.CompetitionService;
import com.example.demo.service.DaymatchService;
import com.example.demo.service.TeamInCompetitionService;
import com.example.demo.service.TeamService;



@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class CompetitionController {
	
	private final CompetitionService service;
	private final TeamInCompetitionService teamCservice;
	private final TeamService teamservice;
	private final DaymatchService dayservice;
	
	
	CompetitionController(CompetitionService service,TeamInCompetitionService teamCservice,TeamService teamservice,DaymatchService dayservice) {
		
		this.service = service;
		this.teamCservice = teamCservice;
		this.teamservice=teamservice;
		this.dayservice=dayservice;
	}
	
	@CrossOrigin(origins = "http://localhost:8100")
	@GetMapping("/competition/{id}")
	Competition getCompetition(@PathVariable Long id){
		return service.findById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:8100")
	@GetMapping("/competitions")
	List<Competition> getAllCompetition(){
		List<Competition> all = new ArrayList<Competition>(service.getAllCompetition());
		return all;
	}
	
	@CrossOrigin(origins = "http://localhost:8100")
	@GetMapping("/competition/{id}/team")
	List<Team> getTeam(@PathVariable Long id){
		Competition comp = service.findById(id);
		return teamCservice.getAllTeamByCompetition(comp);
	}
	
	@CrossOrigin(origins = "http://localhost:8100")
	@GetMapping("/competition/match/{idc}/{idt}")
	List<Match> getMatchByTeam(@PathVariable Long idc,@PathVariable Long idt){
		List<Match>result=new ArrayList<Match>();
		Competition comp = service.findById(idc);
		Team t = teamservice.findById(idt);
		if(teamCservice.getAllCompetitionByTeam(t).contains(comp)) {
			for(Daymatch d : dayservice.getByCompetition(idc)) {
				for(Match m : d.getMatchs()) {
					if(m.getHome().equals(t)||m.getVisitor().equals(t)) {
						result.add(m);
					}
				}
			}	
		}
		return result;

	}
	
	
	
}
