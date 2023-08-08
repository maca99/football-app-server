package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.business.CountryService;
import com.example.demo.domain.Country;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class ZoneController {

	
private final CountryService service;
	
	ZoneController(CountryService service){
		this.service=service;
	}
	
	@PostMapping("/add-zone")
	Country add_country(@RequestBody Country country) {
		return service.add_Country(country);
	}
	
	@GetMapping("/zone/{id}")
	Country get_Country(@PathVariable Long id) {
		return service.get_Country(id);
	}
}
