package com.masai;

public class Travel {

	Vehicle v;
 
	public void setV(Vehicle v) {
		this.v = v;
	}
	
	public void journey() {
		v.go();
		System.out.println("Journey Started");
	}
	
}
