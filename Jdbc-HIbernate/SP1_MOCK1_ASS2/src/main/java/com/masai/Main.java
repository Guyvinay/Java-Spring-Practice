package com.masai;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext apc = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		MyService myService = apc.getBean("ms" , MyService.class);
		
		myService.connStart();
		
	}
	
}
