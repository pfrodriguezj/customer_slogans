package com.mango.customer.config;

import com.mango.customer.helper.SloganHelper;
import com.mango.customer.helper.SloganHelperImpl;
import com.mango.customer.helper.UserBeanHelper;
import com.mango.customer.helper.UserBeanHelperImpl;
import com.mango.customer.service.SloganService;
import com.mango.customer.service.SloganServiceImpl;
import com.mango.customer.service.UserService;
import com.mango.customer.service.UserServiceImplementation;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class ContextConfigurationTest {
	@Bean
	public UserBeanHelper userHelper() {
		return new UserBeanHelperImpl();
	}

	@Bean
	SloganHelper sloganHelper(){
		return new SloganHelperImpl();
	}

	@Bean
	public UserService userService(){
		return new UserServiceImplementation(userHelper());
	}

	@Bean
	public SloganService sloganService(){
		return new SloganServiceImpl(sloganHelper(), userHelper());
	}

}
