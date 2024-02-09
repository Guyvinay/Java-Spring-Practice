package com.masai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> myException(Exception se , WebRequest req){
    	
        ErrorDetails med = new ErrorDetails();
        med.setMessage(se.getMessage());
        med.setDescription(req.getDescription(false));

        return new ResponseEntity<>(med, HttpStatus.BAD_REQUEST) ;

    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorDetails> NoHandlerFound(NoHandlerFoundException se , WebRequest req){

        ErrorDetails med = new ErrorDetails();
        med.setMessage(se.getMessage());
        med.setDescription(req.getDescription(false));

        return new ResponseEntity<>(med, HttpStatus.BAD_REQUEST) ;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> myException(MethodArgumentNotValidException se , WebRequest req){

        ErrorDetails med = new ErrorDetails();
        med.setMessage(se.getMessage());
        med.setDescription(req.getDescription(false));

        return new ResponseEntity<>(med, HttpStatus.BAD_GATEWAY) ;
    }

    @ExceptionHandler(TweeterException.class)
    public ResponseEntity<ErrorDetails> myException(TweeterException se , WebRequest req){

        ErrorDetails med = new ErrorDetails();
        med.setMessage(se.getMessage());
        med.setDescription(req.getDescription(false));

        return new ResponseEntity<>(med, HttpStatus.BAD_REQUEST) ;
    }
}
