package com.mango.customer.helper;

import com.mango.customer.config.ContextConfigurationTest;
import com.mango.customer.dto.UserDto;
import com.mango.customer.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@Import(ContextConfigurationTest.class)
public class UserBeanHelperTest {

	@Autowired
	UserBeanHelper userBeanHelper;

	@Test
	public void generateUserFromDtoOk() {
		UserDto userDto = new UserDto();
		userDto.setAddress("address");
		userDto.setCity("Barcelona");
		userDto.setLastName("Ximenez");
		userDto.setLastName("Felipe");
		userDto.setEmail("email");
		User user = userBeanHelper.generateUserFromDto(userDto);
		assertThat(user.getEmail()).isEqualTo(userDto.getEmail());
		assertThat(user.getAddress()).isEqualTo(userDto.getAddress());
		assertThat(user.getCity()).isEqualTo(userDto.getCity());
		assertThat(user.getLastName()).isEqualTo(userDto.getLastName());
		assertThat(user.getName()).isEqualTo(userDto.getName());
	}

	@Test
	public void saveUserOk() {
		UserDto userDto = new UserDto();
		userDto.setAddress("address");
		userDto.setCity("Barcelona");
		userDto.setLastName("Ximenez");
		userDto.setLastName("Felipe");
		userDto.setEmail("email");
		User user = userBeanHelper.generateUserFromDto(userDto);
		User savedUser = userBeanHelper.saveUser(user);
		assertThat(savedUser.getEmail()).isEqualTo(userDto.getEmail());
		assertThat(savedUser.getAddress()).isEqualTo(userDto.getAddress());
		assertThat(savedUser.getCity()).isEqualTo(userDto.getCity());
		assertThat(savedUser.getLastName()).isEqualTo(userDto.getLastName());
		assertThat(savedUser.getName()).isEqualTo(userDto.getName());
	}

	@Test
	public void findUserByEmailOk() {
		UserDto userDto = new UserDto();
		userDto.setAddress("address");
		userDto.setCity("Barcelona");
		userDto.setLastName("Ximenez");
		userDto.setLastName("Felipe");
		userDto.setEmail("email");
		User user = userBeanHelper.generateUserFromDto(userDto);
		User savedUser = userBeanHelper.saveUser(user);
		Optional<User> optionalUser = userBeanHelper.findUserByEmail(userDto.getEmail());
		assertThat(optionalUser).isNotEmpty();
		assertThat(savedUser.getId()).isEqualTo(user.getId());
	}

	@Test
	public void findUserByEmail_not_found() {
		UserDto userDto = new UserDto();
		userDto.setAddress("address");
		userDto.setCity("Barcelona");
		userDto.setLastName("Ximenez");
		userDto.setLastName("Felipe");
		userDto.setEmail("email");
		User user = userBeanHelper.generateUserFromDto(userDto);
		User savedUser = userBeanHelper.saveUser(user);
		Optional<User> optionalUser = userBeanHelper.findUserByEmail("email2");
		assertThat(optionalUser).isEmpty();
	}

}
