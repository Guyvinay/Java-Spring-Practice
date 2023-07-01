package com.masai;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@RequestMapping(value = "/hello" , method = RequestMethod.GET)
	public String sayHello() {
		return "welcome";
	}
	
	@RequestMapping(value = "/add" , method = RequestMethod.GET )
//	@ResponseBody
	 public String getResult(Integer num1 , Integer num2 , Model model) {
		
		int result = num1+num2;
		
		model.addAttribute("resultData",result);
		
		 return "result";
		 
	 }
	
}
