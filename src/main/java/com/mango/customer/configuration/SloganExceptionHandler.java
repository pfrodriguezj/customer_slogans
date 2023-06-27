package com.mango.customer.configuration;

import com.mango.customer.exception.MaxSlogansReachedException;
import com.mango.customer.exception.UserNotFoundException;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Configuration
@RestControllerAdvice
public class SloganExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(MaxSlogansReachedException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public ResponseEntity<Object> handleMaxSlogansReachedException(MaxSlogansReachedException e){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
	}

}
