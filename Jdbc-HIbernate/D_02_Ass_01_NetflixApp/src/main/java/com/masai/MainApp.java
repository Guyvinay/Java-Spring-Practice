package com.masai;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext apc = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserService userService = apc.getBean("us" , UserService.class);
		userService.userService();;
	}
}
