package com.example.demo.business;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Match;
import com.example.demo.repository.MatchRepository;


@Service
public class MatchService {
	
	private final MatchRepository repository;
	
	public MatchService(MatchRepository repository) {
		this.repository=repository;
	}
	
	public Match findById(Long id) {
		return repository.findById(id).orElseThrow();
	}
}
