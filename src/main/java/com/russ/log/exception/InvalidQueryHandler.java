package com.russ.log.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InvalidQueryHandler {
	
	@ExceptionHandler(value = InvalidQueryException.class)
	public ResponseEntity<Object> handleInvalidQuery(InvalidQueryException e){
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		InvalidException invalidException =
		new InvalidException(e.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now());
		
		return new ResponseEntity<>(invalidException,badRequest);
		 
	}

}
