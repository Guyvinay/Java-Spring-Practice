package com.app.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	//To handle any kind of exceptions
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionDef> globalExceptiopnHandlerEntity(Exception ex, WebRequest wb){
		return new ResponseEntity<ExceptionDef>(
				new ExceptionDef(
						LocalDateTime.now(),
						ex.getMessage(),
						wb.getDescription(false)
						),
				HttpStatus.NO_CONTENT
				);
	}

	//to handle specific NotFoundException
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ExceptionDef> notFoundExceptionHandlerEntity(NotFoundException ex, WebRequest wb){
		return new ResponseEntity<ExceptionDef>(
				new ExceptionDef(
						LocalDateTime.now(),
						ex.getMessage(),
						wb.getDescription(false)
						),
				HttpStatus.NO_CONTENT
				);
	}
	
}
