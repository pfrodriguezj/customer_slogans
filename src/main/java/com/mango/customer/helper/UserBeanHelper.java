package com.mango.customer.helper;

import com.mango.customer.dto.UserDto;
import com.mango.customer.model.User;

import java.util.Optional;

public interface UserBeanHelper {
	User generateUserFromDto(UserDto userDto);
	User saveUser(User user);

	Optional<User> findUserByEmail(String email);

	Boolean remove(User user);
}
