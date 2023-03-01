package com.russ.log.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class InvalidException {
	private final String message;
//	private final Throwable throwable;
	private final HttpStatus httpstatus;
	private final ZonedDateTime timestamp;

	public InvalidException(String message, HttpStatus httpstatus, ZonedDateTime timestamp) {
		super();
		this.message = message;
//		this.throwable = throwable;
		this.httpstatus = httpstatus;
		this.timestamp = timestamp;
	}

}
