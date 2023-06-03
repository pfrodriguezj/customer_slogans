package com.mango.customer.service;

import com.mango.customer.helper.UserBeanHelper;
import com.mango.customer.dto.UserDto;
import com.mango.customer.exception.UserNotFoundException;
import com.mango.customer.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

	private UserBeanHelper userBeanHelper;

	public UserServiceImplementation(UserBeanHelper userBeanHelper) {
		this.userBeanHelper = userBeanHelper;
	}

	@Override
	public User saveUser(UserDto userDto) {
		User u = userBeanHelper.generateUserFromDto(userDto);
		return userBeanHelper.saveUser(u);
	}

	@Override
	public User updateUser(UserDto userDto) throws UserNotFoundException {
		User user = userBeanHelper.findUserByEmail(userDto.getEmail()).orElseThrow(UserNotFoundException::new);
		user.setName(userDto.getName());
		user.setLastName(userDto.getLastName());
		user.setCity(userDto.getCity());
		user.setAddress(userDto.getAddress());
		return userBeanHelper.saveUser(user);
	}
}
