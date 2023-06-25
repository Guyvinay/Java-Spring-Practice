package com.masai;

public class Bike implements Vehicle{

	public void rideBike() {
		System.out.println("Bike Start...");
	}

	@Override
	public void go() {
		rideBike();
		
	}
	
}
