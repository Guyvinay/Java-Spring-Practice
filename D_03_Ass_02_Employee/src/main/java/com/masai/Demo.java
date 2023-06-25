package com.masai;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * empId
empName
address
salary
 */

public class Demo {

	private Map<Department, Employee> theMap;
	
	public Map<Department, Employee> getTheMap() {
		return theMap;
	}
	public void setTheMap(Map<Department, Employee> theMap) {
		this.theMap = theMap;
	}
	public void myInit() {
		System.out.println("inside myInit method");
	}
	public void cleanUP() {
		System.out.println("inside cleanUp method");
	}
	public void showDetails() {
		for(Map.Entry<Department, Employee>ent : theMap.entrySet() ) {
			
			System.out.println(ent);
			
		}
	}
	
	public static void main(String[] args) {
		
		ApplicationContext apt = new ClassPathXmlApplicationContext("applicationContext.xml");

		Demo demo = apt.getBean(Demo.class , "demo");
		demo.showDetails();
		
		
		ClassPathXmlApplicationContext dest = (ClassPathXmlApplicationContext) apt;
		
		dest.close();
		
	}
	
	
	
}
