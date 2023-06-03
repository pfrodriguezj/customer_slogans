package com.mango.customer.service;

import com.mango.customer.dto.SloganDto;
import com.mango.customer.exception.MaxSlogansReachedException;
import com.mango.customer.exception.UserNotFoundException;
import com.mango.customer.model.Slogan;

public interface SloganService {

	Slogan save(SloganDto sloganDto) throws UserNotFoundException, MaxSlogansReachedException;

}
