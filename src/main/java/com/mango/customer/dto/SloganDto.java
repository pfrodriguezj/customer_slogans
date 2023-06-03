package com.mango.customer.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class SloganDto {

	@Email(message = "email must have email format")
	private String email;

	@NotNull
	private String slogan;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
}
