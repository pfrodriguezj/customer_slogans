package com.mango.customer.configuration;

import com.mango.customer.helper.SloganHelper;
import com.mango.customer.helper.SloganHelperImpl;
import com.mango.customer.helper.UserBeanHelper;
import com.mango.customer.helper.UserBeanHelperImpl;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MangoCustomerConfiguration {

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public SloganHelper sloganHelper(){
		return new SloganHelperImpl();
	}

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public UserBeanHelper userBeanHelper(){
		return new UserBeanHelperImpl();
	}


}
