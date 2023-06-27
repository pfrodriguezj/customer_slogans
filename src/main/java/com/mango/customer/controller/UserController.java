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

	@PostMapping("/v1/user")
	public void addUser(@Valid @RequestBody UserDto userDto){
		userService.saveUser(userDto);
	}

	@PutMapping("/v1/user")
	public void updateUser(@Valid @RequestBody UserDto userDto) throws UserNotFoundException {
		userService.updateUser(userDto);
	}

}
