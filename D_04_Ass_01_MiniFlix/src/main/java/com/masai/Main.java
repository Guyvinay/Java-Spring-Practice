package com.masai;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.masai.Config.AppConfig;
import com.masai.Controller.MovieController;
import com.masai.Controller.SeriesController;
import com.masai.Entity.Movie;
import com.masai.Entity.Series;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext apc = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MovieController mvc = apc.getBean("movieController" , MovieController.class);
		
		SeriesController ssc = apc.getBean("seriesController" , SeriesController.class);
		
		mvc.addMovie(new Movie(1 , "AVATAR"));
		ssc.addSeries(new Series(1, "ASUR"));
		
		mvc.addMovie(new Movie(2 , "FAST x"));
		ssc.addSeries(new Series(3, "MH"));
		
		System.out.println(mvc.getMovie(1));
		System.out.println(ssc.getSeries(1));
		System.out.println(mvc.getMovie(2));
		System.out.println(ssc.getSeries(3));
		
		
		((AnnotationConfigApplicationContext)apc).close();
	}
	
}
