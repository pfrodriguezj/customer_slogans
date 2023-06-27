package com.mango.customer.service;

import com.mango.customer.config.ContextConfigurationTest;
import com.mango.customer.dto.SloganDto;
import com.mango.customer.dto.UserDto;
import com.mango.customer.exception.MaxSlogansReachedException;
import com.mango.customer.exception.UserNotFoundException;
import com.mango.customer.helper.UserBeanHelper;
import com.mango.customer.model.Slogan;
import com.mango.customer.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@Import(ContextConfigurationTest.class)
public class SloganServiceTest {


	@Autowired
	SloganService sloganService;

	@MockBean
	private UserBeanHelper userBeanHelper;

	@Test
	public void saveSloganTest() throws UserNotFoundException, MaxSlogansReachedException {
		SloganDto sloganDto = new SloganDto();
		sloganDto.setSlogan("slogan");
		sloganDto.setEmail("email");

		User user = new User();
		user.setId(UUID.randomUUID());
		user.setEmail("email");

		Mockito.when(userBeanHelper.findUserByEmail("email")).thenReturn(Optional.of(user));

		Slogan savedSlogan = sloganService.save(sloganDto);

		assertThat(savedSlogan.getSlogan()).isEqualTo(sloganDto.getSlogan());
		assertThat(savedSlogan.getEmail()).isEqualTo(sloganDto.getEmail());
	}


	@Test(expected = MaxSlogansReachedException.class)
	public void saveSloganTest_fail() throws UserNotFoundException, MaxSlogansReachedException {
		SloganDto sloganDto1 = new SloganDto();
		sloganDto1.setSlogan("slogan");
		sloganDto1.setEmail("email");

		SloganDto sloganDto2 = new SloganDto();
		sloganDto2.setSlogan("slogan");
		sloganDto2.setEmail("email");

		SloganDto sloganDto3 = new SloganDto();
		sloganDto3.setSlogan("slogan");
		sloganDto3.setEmail("email");

		SloganDto sloganDto4 = new SloganDto();
		sloganDto4.setSlogan("slogan");
		sloganDto4.setEmail("email");

		User user = new User();
		user.setId(UUID.randomUUID());
		user.setEmail("email");

		Mockito.when(userBeanHelper.findUserByEmail("email")).thenReturn(Optional.of(user));

		sloganService.save(sloganDto1);
		sloganService.save(sloganDto2);
		sloganService.save(sloganDto3);
		sloganService.save(sloganDto4);
	}
}
