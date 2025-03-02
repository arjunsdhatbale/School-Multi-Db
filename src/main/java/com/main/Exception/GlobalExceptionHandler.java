package com.main.Exception;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger log = Logger.getLogger(GlobalExceptionHandler.class);		     			
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException ex) {
	    log.error("Error occurred: {}"); // Changed to error level for better visibility
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}

}
