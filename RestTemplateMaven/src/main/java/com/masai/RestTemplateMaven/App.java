package com.masai.RestTemplateMaven;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.RestTemplate;

public class App 
{	
	public static void main(String[] args) {
		
//		RestTemplate restTemplate = new RestTemplate();
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
		RestTempClass bean = applicationContext.getBean("restTempClass",RestTempClass.class);
//		bean.getEmployee(52);
//		bean.registerEmployee(new EmployeeDTO("Barbie", "Noida", 45000));
	    bean.callingSecureAPI("ram@gmail.com", "1234");
	}
}
