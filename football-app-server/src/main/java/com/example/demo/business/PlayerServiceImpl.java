package com.example.demo.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Player;
import com.example.demo.domain.Team;
import com.example.demo.service.PlayerService;
import com.example.demo.service.TeamService;

@Service
public class PlayerServiceImpl implements PlayerService {
	
	private Map<Long,Player> players;
	
	public PlayerServiceImpl(TeamService t) {
		players = new HashMap<Long,Player>();
		
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("static/Player.txt");
			     BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        // Processa la riga e crea un'istanza di Competition
		        String[] tokens = line.split(",");
		        Long id = Long.parseLong(tokens[0]);
		        String name = tokens[1];
		        String surname = tokens[2];
		        Team team = t.findById(Long.parseLong(tokens[3]));
		        Integer shirt = Integer.parseInt(tokens[4]);
		        
		        players.put(id,new Player(id,name,surname,team,shirt));
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	
}
