package com.example.demo.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.News;
import com.example.demo.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {
	
	private HashMap<String,News> news;
	
	public NewsServiceImpl() {
		news=new HashMap<String, News>();
		News s1 = new News("","");
		news.put(s1.getTitolo(), s1);
	}

	@Override
	public News save(News news) {
		this.news.put(news.getTitolo(), news);
		return news;
	}

	@Override
	public News findByTitle(String titolo) {
		return news.get(titolo);
	}

	@Override
	public List<News> findAll() {
		List<News> list = new ArrayList<News>(news.values());
		return list;
	}

}
