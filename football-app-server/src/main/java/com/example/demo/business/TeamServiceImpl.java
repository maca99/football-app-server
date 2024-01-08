package com.example.demo.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;



import com.example.demo.domain.Team;
import com.example.demo.service.TeamService;


public class TeamServiceImpl implements TeamService {
	
	private Map<Long,Team> teams;
	
	
	public TeamServiceImpl() {
		
		teams = new HashMap<Long,Team>();

		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("static/Team.txt");
			     BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        // Processa la riga e crea un'istanza di Competition
		        String[] tokens = line.split(",");
		        Long id = Long.parseLong(tokens[0]);
		        String name = tokens[1];
		        String descrizione = tokens[2];
		        String image = tokens[3];
		        
		        teams.put(id,new Team(id,name,descrizione,image));
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

	@Override
	public Team findById(Long id) {
		return teams.get(id);
	}

	@Override
	public Team findByname(String name) {
		for(Team t: teams.values()) {
			if(t.getName().equals(name)) return t;
		}
		return null;
	}

	@Override
	public Collection<Team> getAllTeam() {
		return teams.values();
	}
	


}
