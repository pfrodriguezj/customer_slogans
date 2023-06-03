package com.mango.customer.helper;

import com.mango.customer.dto.UserDto;
import com.mango.customer.model.User;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;


public class UserBeanHelperImpl implements UserBeanHelper {

	private Set<User> users = new HashSet<>();

	@Override
	public User generateUserFromDto(UserDto userDto) {
		User u = new User();
		u.setId(UUID.randomUUID());
		u.setName(userDto.getName());
		u.setLastName(userDto.getLastName());
		u.setAddress(userDto.getAddress());
		u.setCity(userDto.getCity());
		u.setEmail(userDto.getEmail());
		return u;
	}

	@Override
	public User saveUser(User user) {
		users.add(user);
		return user;
	}

	@Override
	public Optional<User> findUserByEmail(String email) {
		return users.stream().filter(user -> user.getEmail().equalsIgnoreCase(email)).findFirst();
	}


}
