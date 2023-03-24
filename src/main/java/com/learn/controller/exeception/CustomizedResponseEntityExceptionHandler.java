package com.learn.controller.exeception;

import java.time.LocalDate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	public CustomizedResponseEntityExceptionHandler() {
   	
	}
    @ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) throws Exception {
		
		ErrorDetails ed = new ErrorDetails(request.getDescription(false),LocalDate.now(), ex.getMessage());
		System.out.println("----------Request Description:"+ request.getDescription(false));
		System.out.println("--------Timestamp:"+ LocalDate.now());
		System.out.println("---------Executpion Message:"+ ex.getMessage());
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.INTERNAL_SERVER_ERROR);
				
	}
		
    @ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		
		ErrorDetails ed = new ErrorDetails(request.getDescription(false),LocalDate.now(), ex.getMessage());
		System.out.println("---------- handleUserNotFoundException Request Description:"+ request.getDescription(false));
		System.out.println("-------- handleUserNotFoundException Timestamp:"+ LocalDate.now());
		System.out.println("--------- handleUserNotFoundExceptionExecutpion Message:"+ ex.getMessage());
		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.NOT_FOUND);
				
	}
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    	ErrorDetails ed = new ErrorDetails(request.getDescription(false),LocalDate.now(), ex.getFieldError().getDefaultMessage());
		return  new ResponseEntity(ed,HttpStatus.BAD_REQUEST);
	}

}
