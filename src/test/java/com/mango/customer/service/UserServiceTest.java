package com.mango.customer.service;

import com.mango.customer.config.ContextConfigurationTest;
import com.mango.customer.dto.UserDto;
import com.mango.customer.exception.UserNotFoundException;
import com.mango.customer.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@Import(ContextConfigurationTest.class)
public class UserServiceTest {


	@Autowired
	UserService userService;

	@Test
	public void saveUserTest() {
		UserDto userDto = new UserDto();
		userDto.setEmail("email");
		userDto.setName("Felipe");
		userDto.setLastName("Ximenez");

		User savedUser = userService.saveUser(userDto);
		assertThat(savedUser.getId()).isNotNull();
	}


	@Test
	public void updateUserTest() throws UserNotFoundException {
		UserDto userDto = new UserDto();
		userDto.setEmail("email");
		userDto.setName("Felipe");
		userDto.setLastName("Ximenez");
		userDto.setCity("city");

		User savedUser = userService.saveUser(userDto);

		userDto.setCity("new city");
		User updatedUser = userService.updateUser(userDto);

		assertThat(updatedUser.getId()).isEqualTo(savedUser.getId());
		assertThat(updatedUser.getCity()).isEqualTo("new city");
	}

	@Test(expected = UserNotFoundException.class)
	public void updateUserTest_fail() throws UserNotFoundException {
		UserDto userDto = new UserDto();
		userDto.setEmail("email");
		userDto.setName("Felipe");
		userDto.setLastName("Ximenez");
		userDto.setCity("city");

		User savedUser = userService.saveUser(userDto);

		userDto.setCity("new city");
		userDto.setEmail("other_mail");
		User updatedUser = userService.updateUser(userDto);
	}

}
