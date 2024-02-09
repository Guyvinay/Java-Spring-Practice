package com.masai;

import java.util.Map;

import org.springframework.context.annotation.Scope;

@Scope(scopeName = "singleton")
public class HolidayPlanner {

	private Map<Hotel, Package> theMap;

	public Map<Hotel, Package> getTheMap() {
		return theMap;
	}

	public void setTheMap(Map<Hotel, Package> theMap) {
		this.theMap = theMap;
	}
	
	public void initialize(){
		System.out.println("inside initialize method");
	}

	public void terminate(){
		System.out.println("inside terminate method");
	}

	public void displayDetails(){
		System.out.println("inside displayDetails of HolidayPlanner class");
		System.out.println();
		for(Map.Entry<Hotel, Package> ent : theMap.entrySet()) {
			System.out.println(ent.getKey());
			System.out.println(ent.getValue());
			System.out.println();
		}
	}
	
	
	
}
