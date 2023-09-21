package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.NewsServiceImpl;
import com.example.demo.domain.News;

@RestController
public class NewsController {
	private final NewsServiceImpl service;
	
	public NewsController(NewsServiceImpl service) {
		this.service=service;
	}
	
	@CrossOrigin(origins = "http://localhost:8100")
	
	@GetMapping("/news")
	List<News> getAllNews() {
		List<News>news = new ArrayList<News>(service.findAll());
		Collections.sort(news);
		return news;
	}
	@GetMapping("/news/{titolo}")
	News findNews(@PathVariable String titolo) {
		return service.findByTitle(titolo);
	}
	
	
}
