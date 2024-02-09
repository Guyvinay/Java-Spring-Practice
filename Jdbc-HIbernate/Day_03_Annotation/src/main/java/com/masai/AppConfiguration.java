package com.masai;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan(basePackages = "com.masai")
//@ComponentScan(basePackages = {"com.masai" ,  "com.masai1" })
public class AppConfiguration {
	
	@Bean(value = "cityList")
	public List<String> getCities(){
		List<String> list =  Arrays.asList("Delhi" , "Mumbai" , "Patna" , "JH");
		return list;
	}
	
	@Bean("b1")
//	@Primary
	public B getB() {
		return new B();
	}

	
}
