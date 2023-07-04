package com.masai.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomException {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorDetail> myException(Exception e , WebRequest web) {
		ErrorDetail ed = new ErrorDetail(e.getMessage() ,web.getDescription(false) , LocalDateTime.now());
		return new ResponseEntity<ErrorDetail>(ed , HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetail> myExceptionPre(Exception e , WebRequest web) {
		ErrorDetail ed = new ErrorDetail(e.getMessage() ,web.getDescription(false) , LocalDateTime.now());
		return new ResponseEntity<ErrorDetail>(ed , HttpStatus.BAD_REQUEST);
	}
	
	
	
}
