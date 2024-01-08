package com.example.demo.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.example.demo.domain.Competition;
import com.example.demo.domain.Daymatch;
import com.example.demo.domain.Match;
import com.example.demo.domain.Team;
import com.example.demo.service.CompetitionService;
import com.example.demo.service.DaymatchService;
import com.example.demo.service.MatchService;


public class DaymatchServiceImpl implements DaymatchService {
	
	private Map<Long,Daymatch> days;
	
	private CompetitionService competitions;
	private MatchService matchs;
	
	public DaymatchServiceImpl(CompetitionServiceImpl c,MatchServiceImpl m) {
		this.matchs=m;
		this.competitions=c;
		days = new HashMap<Long,Daymatch>();
		
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("static/Daymatch.txt");
			     BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        // Processa la riga e crea un'istanza di Competition
		        String[] tokens = line.split(",");
		        Long id = Long.parseLong(tokens[0]);
		        short num = Short.parseShort(tokens[1]);
		        Boolean last = Boolean.parseBoolean(tokens[2]);
		        Competition competition = competitions.findById(Long.parseLong(tokens[3]));
		        List<Match> matches = new ArrayList<Match>();
		        if (tokens.length >= 5) {
	                for (int i = 4; i < tokens.length; i++) {
	                    matches.add(matchs.findById(Long.parseLong(tokens[i])));
	                }
	            }
		       
		        days.put(id, new Daymatch(id,last,num,competition,matches));
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

	@Override
	public List<Daymatch> getByCompetition(Long id) {
		List<Daymatch> all = new ArrayList<Daymatch>();
		for(Daymatch m: days.values()) {
			Competition c = m.getCompetition();
			if(c.getId()==id) {
				all.add(m);
			}
		}
		//Collections.sort(all);
		return all;
	}

	@Override
	public List<Match> getAllMatchByTeam(Team team) {
		Long id = team.getId();
		List<Match> result = new ArrayList<Match>();
		for(Daymatch day  : this.getByCompetition(id)) {
			for(Match m : day.getMatchs()) {
				if(m.getHome().equals(team)) result.add(m);
				if(m.getVisitor().equals(team)) result.add(m);	
			}
		}
		return result;
	}

	@Override
	public List<Daymatch> getPlayedDayMatchByCompetition(Competition comp) {
		List<Daymatch> all = new ArrayList<Daymatch>();
		Short num = this.getLastDayMatchByCompetition(comp).getNum();
		for(Daymatch m: this.getByCompetition(comp.getId())) {
			if(num == null) return this.getByCompetition(comp.getId());
			for(int i=0;i<=num;i++) {
				all.add(m);
			}
		}
		Collections.sort(all);
		return all;
	}

	@Override
	public Daymatch getLastDayMatchByCompetition(Competition comp) {
		for(Daymatch d : this.getByCompetition(comp.getId())) {
			if(d.isLast())return d;
		}
		return null;
	}



}
