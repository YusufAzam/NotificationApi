package com.pushbullet.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

@ControllerAdvice
public class DuplicateUserHandler {
	
	@ExceptionHandler(value = {DuplicateUserException.class})
	public ResponseEntity<Object> handleRequestException(DuplicateUserException e) {
		DuplicateException duplicateException = new DuplicateException(e.getMessage(), HttpStatus.CONFLICT, ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(duplicateException,HttpStatus.CONFLICT);
	}
}