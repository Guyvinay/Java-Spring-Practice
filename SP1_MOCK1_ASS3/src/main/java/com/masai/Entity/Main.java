package com.masai.Entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
 public static void main(String[] args) {
//	ApplicationContext apc = new ClassPathXmlApplicationContext("app.xml");
//	GymManager gymManager = apc.getBean("gm" , GymManager.class);
		ApplicationContext apc = new AnnotationConfigApplicationContext(AppConfig.class);
		GymManager gymManager = apc.getBean("gymManager" , GymManager.class);
		WorkoutProgram wp = new WorkoutProgram(1 , "WP1" , "122");
		Member me  = new Member(1, "mem1", 121, "34v");
//		gymManager.putValue(wp, me);
	gymManager.showDetails();
	
}
}
