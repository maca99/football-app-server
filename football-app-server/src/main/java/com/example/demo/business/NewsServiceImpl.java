package com.example.demo.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.domain.News;
import com.example.demo.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {
	
	private Map<String,News> news;
	
	public NewsServiceImpl() {
		news = new HashMap<String,News>();
		
		
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("static/News.txt");
			     BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        // Processa la riga e crea un'istanza di Competition
		        String[] tokens = line.split(",");
		        String titolo = tokens[0];
		        String testo = tokens[1];
		        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		        Date date = dateFormat.parse(tokens[2]);
		        
		        news.put(titolo, new News(titolo,testo,date));
		    }
		} catch (IOException | ParseException e) {
		    e.printStackTrace();
		}
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

	@Override
	public List<News> getRecently() {
		List<News> recently = new ArrayList<News>(news.values());
		Collections.sort(recently);
		return recently;
	}

}
