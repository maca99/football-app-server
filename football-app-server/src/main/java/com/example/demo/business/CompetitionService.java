package com.example.demo.business;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Competition;
import com.example.demo.repository.CompetitionRepository;

@Service
public class CompetitionService {
	
	private final CompetitionRepository repository;

	public CompetitionService(CompetitionRepository repository) {
		super();
		this.repository = repository;
	}
	
	public List<Competition> findAll(){
		return repository.findAll();
	}
	
	public Competition findById(Long id) {
		return repository.findById(id).orElseThrow();
	}
	
	public Competition save(Competition comp) {
		return repository.save(comp);
	}
	
	public void remove(Long id) {
		repository.deleteById(id);
	}

}
