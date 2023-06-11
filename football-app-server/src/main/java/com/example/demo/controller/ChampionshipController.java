package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.ChampionshipService;
import com.example.demo.domain.Championship;


@RestController
public class ChampionshipController {
	
	private final ChampionshipService service;
	
	ChampionshipController(ChampionshipService service){
		this.service=service;
	}
	
	@GetMapping("/championship/{id}")
	Championship getChampionshipById(@PathVariable Long id) {
		return service.findById(id);
	}
	
}
