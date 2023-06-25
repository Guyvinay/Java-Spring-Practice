package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.masai.Entity.Series;
import com.masai.Service.SeriesService;

@Controller
public class SeriesController {

	@Autowired
	private SeriesService serSer;
	
    public void addSeries(Series series) {
		
    	serSer.addSeries(series);
		
	}
	
	public Series getSeries(int id) {
		
		return serSer.getSeries(id);
		
	}
	
}
