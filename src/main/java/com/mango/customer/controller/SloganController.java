package com.mango.customer.controller;

import com.mango.customer.dto.SloganDto;
import com.mango.customer.dto.UserDto;
import com.mango.customer.exception.MaxSlogansReachedException;
import com.mango.customer.exception.UserNotFoundException;
import com.mango.customer.service.SloganService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class SloganController {


	private SloganService sloganService;

	public SloganController(SloganService sloganService) {
		this.sloganService = sloganService;
	}

	@PostMapping("/v1/slogan")
	public void addSlogan(@Valid @RequestBody SloganDto sloganDto) throws UserNotFoundException, MaxSlogansReachedException {
		sloganService.save(sloganDto);
	}

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}

	@ExceptionHandler(MaxSlogansReachedException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public ResponseEntity<String> handleMaxSlogansReachedException(MaxSlogansReachedException e){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
	}



}
