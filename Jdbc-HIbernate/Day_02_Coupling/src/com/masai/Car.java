package com.masai;

public class Car implements Vehicle {
	

	public void start() {
		System.out.println("Car Started");
	}

	@Override
	public void go() {
		start();
	}
	
}
