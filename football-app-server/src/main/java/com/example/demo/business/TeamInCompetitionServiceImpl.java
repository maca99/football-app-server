package com.example.demo.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Competition;
import com.example.demo.domain.Team;
import com.example.demo.service.CompetitionService;
import com.example.demo.service.TeamInCompetitionService;
import com.example.demo.service.TeamService;

@Service
public class TeamInCompetitionServiceImpl implements TeamInCompetitionService{

	private TeamService t;
	private CompetitionService c;
	private Map<Team,List<Competition>> map;
	
	public TeamInCompetitionServiceImpl(TeamService t,CompetitionService c) {
		this.t=t;
		this.c=c;
		map = new HashMap<Team,List<Competition>>();
		
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("static/TeamInCompetition.txt");
			     BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] tokens = line.split(",");
		        Team team = t.findById(Long.parseLong(tokens[0]));
		        Competition competition = c.findById(Long.parseLong(tokens[1]));
		        List<Competition> l = new ArrayList<Competition>();
		        if(map.get(team) != null) {
		        	l=map.get(team);
		        	l.add(competition);
		        	map.replace(team, l);
		        }else {
		        	l.add(competition);
		        	map.put(team,l);
		        }
		       
		        
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	}
	
	@Override
	public List<Team> getAllTeamByCompetition(Competition comp) {
		List<Team> result = new ArrayList<Team>();
		for(Team t : map.keySet()) {
			if(map.get(t).contains(comp)) {
				result.add(t);
			}
		}
		return result;
	}

	@Override
	public List<Competition> getAllCompetitionByTeam(Team t) {
		return map.get(t);
	}

}
