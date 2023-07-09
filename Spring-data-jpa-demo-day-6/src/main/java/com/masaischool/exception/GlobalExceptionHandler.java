package com.masaischool.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<MyErrorDetails> handleStudentNotFoundException(StudentNotFoundException ex, 
			WebRequest we){
		MyErrorDetails details = new MyErrorDetails();
		details.setTimestamp(LocalDateTime.now());
		details.setMessage(ex.getMessage());
		details.setDescription(we.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(details, HttpStatus.BAD_REQUEST);
	}
}
