package com.masaischool;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorEntity> handleException(MethodArgumentNotValidException ex){
		//Create an object of MyErrorEntity
		MyErrorEntity entity = new MyErrorEntity();
		entity.setTimestamp(LocalDateTime.now());
		entity.setMessage("Validation Failed");
		
		//List of all error object is here
		List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
		
		//List of all error messages is here
		List<String> errorMessages = MethodArgumentNotValidException.errorsToStringList(allErrors);
		
		//set the details here
		entity.setDescription(String.join(", ", errorMessages));
		return new ResponseEntity<MyErrorEntity>(entity, HttpStatus.BAD_REQUEST);
		
	}
}
