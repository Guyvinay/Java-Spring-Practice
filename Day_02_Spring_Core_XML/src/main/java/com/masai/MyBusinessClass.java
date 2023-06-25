package com.masai;

public class MyBusinessClass {

	private int roll;
	private String name;
	
	
	
	
	public void setRoll(int roll) {
		this.roll = roll;
	}




	public void setName(String name) {
		this.name = name;
	}




	public void fun1() {
		System.out.println("inside fun1 of MyBusinessClass");
		System.out.println("roll is " + roll);
		System.out.println("name is " + name);
	}
	
}
