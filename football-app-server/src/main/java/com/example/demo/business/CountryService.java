package com.example.demo.business;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Country;
import com.example.demo.repository.CountryRepository;

@Service
public class CountryService {

	private final CountryRepository repository;
	
	
	public CountryService(CountryRepository repository) {
		super();
		this.repository = repository;
	}
	
	public Country add_Country(Country country) {
		repository.save(country);
		return country;
	}
	
	public Country get_Country(Long id) {
		return repository.findById(id).orElseThrow();
	}
}
