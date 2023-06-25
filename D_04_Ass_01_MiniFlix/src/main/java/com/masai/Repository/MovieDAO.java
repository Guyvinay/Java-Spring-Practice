package com.masai.Repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.masai.Entity.Movie;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Repository
public class MovieDAO {

  private HashMap<Integer, Movie> moviesMap ;
	
	@PostConstruct
	public void createDB() {
		moviesMap = new HashMap<>();	
	}
	
	public void addMovie(Movie movie) {
		if(movie == null) throw new RuntimeException("Cannit Null");
		if(moviesMap.get(movie.getId()) != null) throw new RuntimeException("Already");
		moviesMap.put(movie.getId(), movie);
		System.out.println("Added");
	}
	
	public Movie getMovie(int id) {
		Movie movie = moviesMap.get(id);
		if(movie==null) throw new RuntimeException("Not Present");
		return movie;
	}
	
	@PreDestroy
	public void clearDB() {
		
		moviesMap = new HashMap<>();
		System.out.println("Movie DB cleared");
	}
	
}
