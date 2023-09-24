package com.example.demo.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Match;
import com.example.demo.domain.Team;
import com.example.demo.service.TeamService;

@Service
public class MatchServiceImpl implements com.example.demo.service.MatchService {
	
	private Map<Long,Match> matches;
	
	private TeamService teamS;

	public MatchServiceImpl(TeamServiceImpl t) {
		
		teamS=t;
		matches=new HashMap<Long,Match>();
		
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("static/Match.txt");
			     BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        // Processa la riga e crea un'istanza di Competition
		        String[] tokens = line.split(",");
		        Long id = Long.parseLong(tokens[0]);
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        Date date = dateFormat.parse(tokens[1]);
		        Team home = teamS.findById(Long.parseLong(tokens[2]));
		        Team visitor = teamS.findById(Long.parseLong(tokens[3]));
		        Integer home_score = Integer.parseInt(tokens[4]);
		        Integer visitor_score = Integer.parseInt(tokens[5]);
		        
		        matches.put(id,new Match(id,date,home,visitor,home_score,visitor_score));
		    }
		} catch (IOException|ParseException e) {
		    e.printStackTrace();
		} 
	}
	
	@Override
	public Match findById(Long id) {
		return matches.get(id);
	}

	
	@Override
	public Collection<Match> getLastmatchByTeam(Team team) {
		Collection<Match> last = new ArrayList<Match>();
		for(Match m : matches.values()) {
			if(m.getHome().equals(team) || m.getVisitor().equals(team)) last.add(m);
			if(last.size() > 5) break;
		}
		return last;
	}

}
