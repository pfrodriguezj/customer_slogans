package com.mango.customer.helper;

import com.mango.customer.dto.SloganDto;
import com.mango.customer.exception.MaxSlogansReachedException;
import com.mango.customer.exception.UserNotFoundException;
import com.mango.customer.model.Slogan;
import com.mango.customer.model.User;

public interface SloganHelper {

	Slogan generateSloganFromDto(SloganDto sloganDto);
	Slogan saveSlogan(Slogan slogan, User user) throws UserNotFoundException, MaxSlogansReachedException;
	Integer countSloganByUserMail(User user);

}
