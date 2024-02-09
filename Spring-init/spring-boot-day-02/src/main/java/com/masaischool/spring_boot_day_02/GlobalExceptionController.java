package com.masaischool.spring_boot_day_02;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionController {
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> myExceptionHandler(IllegalArgumentException ex){
		System.out.println("Inside myExceptionHandler of GlobalExceptionController");
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)	//this will handle exception of Exception class and its subclass
	public ResponseEntity<MyErrorDetails> myCustomExceptionHandler(Exception ex, WebRequest req){
		//Create an object of MyErrorDetails that contains information about the error
		MyErrorDetails details = new MyErrorDetails(ex.getMessage(), req.getDescription(false), LocalDateTime.now());
		System.out.println("Inside myCustomExceptionHandle of GlobalExceptionController");
		return new ResponseEntity<MyErrorDetails>(details, HttpStatus.BAD_REQUEST);
	}
	
	//https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/context/request/WebRequest.html
	
	//seperate Exception handler for the bad URI
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> getErrorMessage(NoHandlerFoundException ex, WebRequest req){
		MyErrorDetails details = new MyErrorDetails(ex.getMessage(), req.getDescription(false), LocalDateTime.now());
		System.out.println("Bad URI");
		return new ResponseEntity<MyErrorDetails>(details, HttpStatus.BAD_REQUEST);
	}
	
	
	
	
}
