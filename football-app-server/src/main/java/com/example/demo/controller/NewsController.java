package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.NewsService;
import com.example.demo.domain.News;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class NewsController {
	
	private final NewsService service;
	
	NewsController(NewsService service){
		this.service=service;
	}
	
	@GetMapping("/news")
	List<News> getAllNews() {
		List<News>news = new ArrayList<News>(service.findAll());
		Collections.sort(news);
		return news;
	}
	
	@GetMapping("/news/{id}")
	News findNews(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping("/add-news")
	News addNews(@RequestBody News news) {
		return service.save(news);
	}
	
}
