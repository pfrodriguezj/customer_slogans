package com.mango.customer.helper;

import com.mango.customer.dto.SloganDto;
import com.mango.customer.exception.MaxSlogansReachedException;
import com.mango.customer.exception.UserNotFoundException;
import com.mango.customer.model.Slogan;
import com.mango.customer.model.User;

import java.util.*;

public class SloganHelperImpl implements SloganHelper{

	private Map<User, List<Slogan>> slogans = new HashMap();


	@Override
	public Slogan generateSloganFromDto(SloganDto sloganDto) {
		return new Slogan(sloganDto.getEmail(), sloganDto.getSlogan());
	}

	@Override
	public Slogan saveSlogan(Slogan slogan, User user) throws UserNotFoundException, MaxSlogansReachedException {
		if(countSloganByUserMail(user) < 3){
			List<Slogan> slogansList = slogans.get(user);
			if(slogansList == null){
				slogansList = new ArrayList<>();
				slogansList.add(slogan);
				slogans.put(user, slogansList);
			} else {
				slogansList.add(slogan);
			}

		} else {
			throw new MaxSlogansReachedException();
		}
		return slogan;
	}

	@Override
	public Integer countSloganByUserMail(User user) {
		List<Slogan> sloganList = slogans.get(user);
		return Optional.ofNullable(sloganList).map(s->s.size()).orElse(0);
	}
}
