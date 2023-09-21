package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.News;

public interface NewsService {

	public News save(News news);
	
	public News findByTitle(String titolo);
	
	public List<News> findAll();
}
