package com.example.demo.service;

import com.example.demo.domain.Team;

public interface TeamService {
	
 public Team findById(Long id);
 
 public Team findByname(String name);
}
