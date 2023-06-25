package com.masai;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		
//		ApplicationContext apc = new ClassPathXmlApplicationContext("applicationContext.xml");
//		
//		A a = apc.getBean("a" , A.class);
//		a.funA();
//		
//		((ClassPathXmlApplicationContext) apc).close();;
		
		
		ApplicationContext apc = new AnnotationConfigApplicationContext(AppConfiguration.class);	
		A a = apc.getBean("a" , A.class);
		a.funA();
		
	
		((AnnotationConfigApplicationContext)apc).close();
	}
	
}
