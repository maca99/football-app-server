package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Competition;

public interface CompetitionService {
	
	public Competition findById(Long id);
	
	public List<Competition> getAllCompetition();
}
