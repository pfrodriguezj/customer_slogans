package com.mango.customer.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserDto {
	@NotBlank(message = "name must not be empty")
	private String name;

	@NotBlank(message = "lastName must not be empty")
	private String lastName;

	@NotBlank(message = "address must not be empty")
	private String address;

	@NotBlank(message = "city must not be empty")
	private String city;

	@Email(message = "email must have email format")
	private String email;

	public UserDto() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
