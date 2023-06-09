package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.News;
import com.example.demo.repository.NewsRepository;

@RestController
public class NewsController {
	
	private final NewsRepository repository;
	
	NewsController(NewsRepository repository){
		this.repository=repository;
	}
	
	@GetMapping("/news")
	public List<News> getAllNews() {
		return repository.findAll();
	}
	
	
}
