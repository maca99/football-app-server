package com.example.demo.controller;




import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.CompetitionService;
import com.example.demo.domain.Competition;



@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class CompetitionController {
	
	private final CompetitionService service;
	
	
	CompetitionController(CompetitionService service) {
		this.service = service;
	}
	@CrossOrigin(origins = "http://localhost:8100")
	@GetMapping("/competition/{id}")
	Competition getCompetitionForZone(@PathVariable Long id){
		return service.findById(id);
	}
	
	@GetMapping("/competition/country/{id}")
	List<Competition> getAllCompetitionByCountry(@PathVariable Long id){
		List <Competition> list = service.findAll();
		List <Competition> result = new ArrayList<Competition>();
		for(Competition c : list){
			if(c.getCountry().getId() == id ) {
				result.add(c);
			}
		}
		return result;
	}
	
	@PostMapping("/add-competition")
	Competition addCompetition(@RequestBody Competition comp) {
		return service.save(comp);
	}
	
	@GetMapping("/delete-competition/{id}")
	void deleteCompetition(@PathVariable Long id) {
		service.remove(id);
	}
	
	
}
