package com.masai.Entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.masai")
public class AppConfig {

	@Bean
	public  Member getMember() {
		return new Member(1, "mem1", 121, "34v");
	}
	@Bean
	public WorkoutProgram getWorkOut() {
		return new WorkoutProgram(1 , "WP1" , "122");
	}
}
