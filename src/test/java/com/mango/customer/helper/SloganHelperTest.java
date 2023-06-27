package com.mango.customer.helper;

import com.mango.customer.config.ContextConfigurationTest;
import com.mango.customer.dto.SloganDto;
import com.mango.customer.exception.MaxSlogansReachedException;
import com.mango.customer.exception.UserNotFoundException;
import com.mango.customer.model.Slogan;
import static org.assertj.core.api.Assertions.assertThat;

import com.mango.customer.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@Import(ContextConfigurationTest.class)
public class SloganHelperTest {

	@Autowired
	SloganHelper sloganHelper;

	@Test
	public void generateSloganFromDtoOk() {
		SloganDto sloganDto = new SloganDto();
		sloganDto.setSlogan("Slogan");
		sloganDto.setEmail("Email");
		Slogan slogan = sloganHelper.generateSloganFromDto(sloganDto);
		assertThat(slogan.getSlogan()).isEqualTo(sloganDto.getSlogan());
		assertThat(slogan.getEmail()).isEqualTo(sloganDto.getEmail());
	}

	@Test
	public void saveSloganOk() throws UserNotFoundException, MaxSlogansReachedException {
		Slogan slogan = new Slogan();
		slogan.setSlogan("Slogan");
		slogan.setEmail("email");
		User user = new User();
		user.setId(UUID.randomUUID());
		Slogan savedSlogan = sloganHelper.saveSlogan(slogan, user);
		assertThat(savedSlogan.getSlogan()).isEqualTo(slogan.getSlogan());
		assertThat(savedSlogan.getEmail()).isEqualTo(slogan.getEmail());
	}

	@Test(expected = MaxSlogansReachedException.class)
	public void saveSlogan_fail_max_slogans() throws UserNotFoundException, MaxSlogansReachedException {
		Slogan slogan1 = new Slogan();
		slogan1.setSlogan("slogan1");
		slogan1.setEmail("email");
		Slogan slogan2 = new Slogan();
		slogan2.setSlogan("slogan2");
		slogan2.setEmail("email");
		Slogan slogan3 = new Slogan();
		slogan3.setSlogan("slogan3");
		slogan3.setEmail("email");
		Slogan slogan4 = new Slogan();
		slogan4.setSlogan("slogan4");
		slogan4.setEmail("email");

		User user = new User();
		user.setId(UUID.randomUUID());
		sloganHelper.saveSlogan(slogan1, user);
		sloganHelper.saveSlogan(slogan2, user);
		sloganHelper.saveSlogan(slogan3, user);
		sloganHelper.saveSlogan(slogan4, user);

	}


}
