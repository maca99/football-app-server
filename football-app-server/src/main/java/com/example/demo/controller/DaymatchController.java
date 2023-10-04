package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Daymatch;
import com.example.demo.domain.Match;
import com.example.demo.service.DaymatchService;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class DaymatchController {
	
	private DaymatchService service;
	
	public DaymatchController(DaymatchService service) {
		this.service=service;
	}

	@CrossOrigin(origins = "http://localhost:8100")
	@GetMapping("/competition/{id}/daymatch")
	public List<Match> getDayMatchByCompetition(@PathVariable Long id) {
		List<Match>result=new ArrayList<Match>();
		for(Daymatch d : service.getByCompetition(id)) {
			result.addAll(d.getMatchs());
		}
		return result;
	}


}
