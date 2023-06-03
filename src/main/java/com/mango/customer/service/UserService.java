package com.mango.customer.service;

import com.mango.customer.dto.UserDto;
import com.mango.customer.exception.UserNotFoundException;
import com.mango.customer.model.User;

public interface UserService {
	User saveUser(UserDto userDto);
	User updateUser(UserDto userDto) throws UserNotFoundException;
}
