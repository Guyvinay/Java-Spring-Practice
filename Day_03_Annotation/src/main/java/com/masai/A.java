package com.masai;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class A {

	@Autowired
	private B b1;
	
	@Autowired
	List<String> cityLlist;
	
	
	@PostConstruct
	public void setUp() {
		System.out.println("inside set up method");
	}
	
	@PreDestroy
	public void tearDown(){
		System.out.println("inside tear down method");
	}
	
	public void funA() {
		System.out.println("insdie A");
		b1.funB();
		System.out.println(cityLlist);
	}
	
}
