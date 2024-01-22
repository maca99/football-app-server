package com.example.demo.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Competition;
import com.example.demo.service.CompetitionService;

@Service
public class CompetitionServiceImpl implements CompetitionService {
	
	private Map<Long,Competition> competitions;
	
	public CompetitionServiceImpl() {
		
		competitions=new HashMap<Long,Competition>();
		
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("static/Competition.txt");
			     BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        // Processa la riga e crea un'istanza di Competition
		        String[] tokens = line.split(",");
		        Long id = Long.parseLong(tokens[0]);
		        String nome = tokens[1].replaceAll("\"", "");
		        String descrizione = tokens[2];
		        String logo = tokens[3].replaceAll("\"", "");
		        //inserisco dentro la lista
		        competitions.put(id,new Competition(id,nome,descrizione,logo));
		        
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	}

	@Override
	public Collection<Competition> getAllCompetition() {
		return competitions.values();
	}

	@Override
	public Competition findById(Long id) {
		return competitions.get(id);
	}
	

}
