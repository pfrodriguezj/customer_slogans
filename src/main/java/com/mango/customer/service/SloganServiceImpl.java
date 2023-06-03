package com.mango.customer.service;

import com.mango.customer.dto.SloganDto;
import com.mango.customer.exception.MaxSlogansReachedException;
import com.mango.customer.exception.UserNotFoundException;
import com.mango.customer.helper.SloganHelper;
import com.mango.customer.helper.UserBeanHelper;
import com.mango.customer.model.Slogan;
import com.mango.customer.model.User;
import org.springframework.stereotype.Service;

@Service
public class SloganServiceImpl implements SloganService{

	private SloganHelper sloganHelper;

	private UserBeanHelper userHelper;

	public SloganServiceImpl(SloganHelper sloganHelper, UserBeanHelper userHelper) {
		this.sloganHelper = sloganHelper;
		this.userHelper = userHelper;
	}

	@Override
	public Slogan save(SloganDto sloganDto) throws UserNotFoundException, MaxSlogansReachedException {
		User user = userHelper.findUserByEmail(sloganDto.getEmail()).orElseThrow(UserNotFoundException::new);
		return sloganHelper.saveSlogan(sloganHelper.generateSloganFromDto(sloganDto), user);
	}

}
