package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Player;

public interface PlayerService {

	public Player getPlayerByID(Long id);
	
	public List<Player> getPlayerByCompetition(Long id);
}
