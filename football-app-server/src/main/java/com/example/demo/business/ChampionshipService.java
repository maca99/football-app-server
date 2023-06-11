package com.example.demo.business;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Championship;
import com.example.demo.repository.ChampionshipRepository;

@Service
public class ChampionshipService {
	
	private final ChampionshipRepository repository;

	public ChampionshipService(ChampionshipRepository repository) {
		this.repository = repository;
	}
	
	public Championship findById(Long id) {
		return repository.findById(id).orElseThrow();
	}
	

}
