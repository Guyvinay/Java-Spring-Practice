package com.masai.Repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.masai.Entity.Series;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Repository
public class SeriesDAO {

	private HashMap<Integer, Series> seriesMap ;
	
	@PostConstruct
	public void createDB() {
		seriesMap = new HashMap<>();	
	}
	
	public void addSeries(Series series) {
		if(series == null) throw new RuntimeException("Cannit Null");
		if(seriesMap.get(series.getId()) != null) throw new RuntimeException("Already");
		seriesMap.put(series.getId(), series);
		System.out.println("Added");
	}
	
	public Series getSeries(int id) {
		Series series = seriesMap.get(id);
		if(series==null) throw new RuntimeException("Not Present");
		return series;
	}
	
	@PreDestroy
	public void clearDB() {
		
		seriesMap = new HashMap<>();
		System.out.println("Series DB cleared");
	}
	
}
