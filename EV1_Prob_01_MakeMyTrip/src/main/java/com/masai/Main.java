package com.masai;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext apc = new ClassPathXmlApplicationContext("appContext.xml");
		HolidayPlanner holidayPlanner = apc.getBean("hP" , HolidayPlanner.class);
		
		holidayPlanner.displayDetails();
		
		((ClassPathXmlApplicationContext)apc).close();
		
	}
	
}
