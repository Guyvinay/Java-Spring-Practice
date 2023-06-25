package com.masai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.Movie;
import com.masai.Repository.MovieDAO;

@Service
public class MovieService {

	@Autowired
	private MovieDAO movieDao;
	
	public void addMovie(Movie movie) {
		
		movieDao.addMovie(movie);
		
	}
	
	public Movie getMovie(int id) {
		
		return movieDao.getMovie(id);
		
	}
	
}
