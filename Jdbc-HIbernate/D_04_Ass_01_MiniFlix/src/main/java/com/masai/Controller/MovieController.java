package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.masai.Entity.Movie;
import com.masai.Repository.MovieDAO;
import com.masai.Service.MovieService;

@Controller
public class MovieController {

	@Autowired
	private MovieService movieSer;
	
	public void addMovie(Movie movie) {
		
		movieSer.addMovie(movie);
		
	}
	
	public Movie getMovie(int id) {
		
		return movieSer.getMovie(id);
		
	}
	
}
