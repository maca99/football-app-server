package com.example.demo.business;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.domain.News;
import com.example.demo.repository.NewsRepository;

@Service
public class NewsService {

	private final NewsRepository repository;
	
	public NewsService(NewsRepository repository) {
		this.repository=repository;
	}
	
	public List<News> findAll(){
		return repository.findAll();
	}
	
	public News findById(Long id) {
		return repository.findById(id).orElseThrow();
		
	}
	public News save(News news) {
		return repository.save(news);
	}
}
