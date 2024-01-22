package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Player;
import com.example.demo.service.PlayerService;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class PlayerController {

	private final PlayerService service;
	
	
	public PlayerController(PlayerService service) {
		this.service=service;
	}
	
	@GetMapping("/player/{id}")
	public Player getPlayerByID(@PathVariable Long id) {
		return service.getPlayerByID(id);
	}
	
	@GetMapping("/competition/{id}/topscorers")
	public List<Map<String,Object>> getTopScorersByCompetition(@PathVariable Long id){
		Random random = new Random();
		List<Map<String, Object>> result=new ArrayList<Map<String,Object>>();
		List<Player>players = service.getPlayerByCompetition(id);
		for(Player p : players) {
			Map<String,Object> map = new HashMap<>();
			map.put("player", p);
			map.put("goals", random.nextInt(33));
			result.add(map);
			if(result.size() > 10)break;
		}
		
		 Collections.sort(result, (mapA, mapB) -> {
	            Integer pointsA = (Integer) mapA.get("goals");
	            Integer pointsB = (Integer) mapB.get("goals");
	            return pointsB.compareTo(pointsA);
	        });
		
		return result;
	}
}
