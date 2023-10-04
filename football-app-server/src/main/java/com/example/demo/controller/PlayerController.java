package com.example.demo.controller;

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
}
