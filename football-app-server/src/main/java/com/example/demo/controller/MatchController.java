package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.business.MatchServiceImpl;
import com.example.demo.domain.Match;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class MatchController {

private final MatchServiceImpl service;
	
	MatchController(MatchServiceImpl service){
		this.service=service;
	}
	
	@GetMapping("/match/{id}")
	Match findMatch(@PathVariable Long id) {
		return service.findById(id);
	}
	@GetMapping("/match/today")
	public Map<String,List<Match>> getTodayMatches(){
		Map<String,List<Match>> result = new HashMap<String,List<Match>>();
		
		return result;
	}
}
