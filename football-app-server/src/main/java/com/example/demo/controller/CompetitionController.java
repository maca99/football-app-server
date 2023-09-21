package com.example.demo.controller;




import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.business.CompetitionServiceImpl;
import com.example.demo.domain.Competition;



@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class CompetitionController {
	
	private final CompetitionServiceImpl service;
	
	
	CompetitionController(CompetitionServiceImpl service) {
		this.service = service;
	}
	
	@CrossOrigin(origins = "http://localhost:8100")
	@GetMapping("/competition/{id}")
	Competition getCompetition(@PathVariable Long id){
		return service.findById(id);
	}
	
	@GetMapping("/competitions/")
	List<Competition> getAllCompetition(){
		return null;
	}
	
	
	
}
