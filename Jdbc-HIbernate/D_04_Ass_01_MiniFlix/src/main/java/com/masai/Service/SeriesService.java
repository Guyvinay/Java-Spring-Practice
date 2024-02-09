package com.masai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.Movie;
import com.masai.Entity.Series;
import com.masai.Repository.SeriesDAO;

@Service
public class SeriesService {

	@Autowired
	private SeriesDAO seriesDAO;
	
	public void addSeries(Series series) {
		
		seriesDAO.addSeries(series);
		
	}
	
	public Series getSeries(int id) {
		
		return seriesDAO.getSeries(id);
		
	}
	
}
