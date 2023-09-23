package com.example.demo.business;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Match;
import com.example.demo.domain.Team;

@Service
public class MatchServiceImpl implements com.example.demo.service.MatchService {

	@Override
	public Match findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Match> getLastmatchByTeam(Team team) {
		// TODO Auto-generated method stub
		return null;
	}

}
