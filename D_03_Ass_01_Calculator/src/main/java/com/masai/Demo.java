package com.masai;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

	public static void main(String[] args) {
		
		ApplicationContext apt = new ClassPathXmlApplicationContext("applicationContext.xml");
		Calculator cal = apt.getBean(Calculator.class , "calculator");
		int add = cal.addition(12, 12);
		int subs = cal.subtraction(20, 10);
		int mult = cal.multiplication(12, 12);
		int div  = cal.division(144, 12);
		System.out.println(add);
		System.out.println(subs);
		System.out.println(mult);
		System.out.println(div);
	}
	
}
