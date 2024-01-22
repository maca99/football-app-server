package com.example.demo.controller;




import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public List<Competition> getAllCompetition(){
		List<Competition> all = new ArrayList<Competition>(service.getAllCompetition());
		return all;
	}
	
	@CrossOrigin(origins = "http://localhost:8100")
	@GetMapping("/competition/match/{idc}/{idt}")
	public List<Match> getMatchByTeam(@PathVariable Long idc,@PathVariable Long idt){
		List<Match>result=new ArrayList<Match>();
		Competition comp = service.findById(idc);
		Team t = teamservice.findById(idt);
		if(teamCservice.getAllCompetitionByTeam(t).contains(comp)) {
			for(Daymatch d : dayservice.getByCompetition(idc)) {
				for(Match m : d.getMatches()) {
					if(m.getHome().equals(t)||m.getVisitor().equals(t)) {
						result.add(m);
					}
				}
			}	
		}
		return result;
	}
	
	@CrossOrigin(origins = "http://localhost:8100")
	@GetMapping("/competition/{id}/ranking")
	@ResponseBody
	public List<Map<String,Object>> getRankingByCompetition(@PathVariable Long id){
		Competition comp = service.findById(id);
		List<Map<String, Object>> result = new ArrayList<>();
		
		Random random = new Random();
		for(Team t : teamCservice.getAllTeamByCompetition(comp)) {
			Map<String,Object>teamData= new HashMap<>();
			Integer totalMatches = 38; // Totale delle partite
            Integer wins = (Integer) (random.nextInt(10) + 10); // Vittorie casuali tra 10 e 19
            Integer draws = (Integer) (random.nextInt(10) + 10); // Pareggi casuali tra 10 e 19
            Integer losses = totalMatches - wins - draws; // Calcola le sconfitte
            Integer goalsFor = (Integer) (random.nextInt(30) + 30); // Gol fatti casuali tra 30 e 59
            Integer goalsAgainst = totalMatches - goalsFor;
            Integer point = wins*3+draws;
            
            teamData.put("team", t);
            teamData.put("totalMatches", totalMatches);
            teamData.put("points", point);
            teamData.put("wins", wins);
            teamData.put("draws", draws);
            teamData.put("losses", losses);
            teamData.put("goalsFor", goalsFor);
            teamData.put("goalsAgainst", goalsAgainst);
            result.add(teamData);
			
		}
		  Collections.sort(result, (teamDataA, teamDataB) -> {
	            Integer pointsA = (Integer) teamDataA.get("points");
	            Integer pointsB = (Integer) teamDataB.get("points");
	            return pointsB.compareTo(pointsA);
	        });
		  
		return result;

	}
	
	
	
}
