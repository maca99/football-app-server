package com.example.demo.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Competition;
import com.example.demo.service.CompetitionService;


@Service
public class CompetitionServiceImpl implements CompetitionService {
	
	List<Competition> competitions;
	
	public CompetitionServiceImpl() {
		competitions=new ArrayList<Competition>();
		
		
	}

	@Override
	public Competition findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Competition> getAllCompetition() {
		// TODO Auto-generated method stub
		return null;
	}

}
