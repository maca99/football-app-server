package com.example.demo.controller;

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
	
}
