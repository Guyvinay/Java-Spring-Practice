package com.masai.Entity;

public class Series {

	private int id;
	private String movieName;
	public Series() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Series(int id, String movieName) {
		super();
		this.id = id;
		this.movieName = movieName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	@Override
	public String toString() {
		return "Series [id=" + id + ", movieName=" + movieName + "]";
	}
	
	
}
