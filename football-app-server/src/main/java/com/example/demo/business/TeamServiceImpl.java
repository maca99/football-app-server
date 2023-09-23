package com.example.demo.business;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Team;
import com.example.demo.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {
	
	
	public Map<Long,Team> teams = new HashMap<Long,Team>();
	
	public TeamServiceImpl() {
		
	}

	@Override
	public Team findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
