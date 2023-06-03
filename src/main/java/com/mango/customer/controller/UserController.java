package com.mango.customer.controller;

import com.mango.customer.dto.UserDto;
import com.mango.customer.exception.UserNotFoundException;
import com.mango.customer.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/signIn")
	public void addUser(@Valid @RequestBody UserDto userDto){
		userService.saveUser(userDto);
	}

	@PutMapping("/updateUser")
	public void updateUser(@Valid @RequestBody UserDto userDto) throws UserNotFoundException {
		userService.updateUser(userDto);
	}

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
}
