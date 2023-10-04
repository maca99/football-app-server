package com.example.demo.service;


import java.util.Collection;

import com.example.demo.domain.Competition;


public interface CompetitionService {
	
	public Competition findById(Long id);
	
	public Collection<Competition> getAllCompetition();
	

	

}
