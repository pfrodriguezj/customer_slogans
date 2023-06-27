package com.mango.customer.model;

import java.util.UUID;

public class User {

	private UUID id;
	private String name;
	private String lastName;
	private String address;
	private String city;
	private String email;

	public User() {
	}

	public User(UUID id, String name, String lastName, String address, String city, String email) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.email = email;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		return getId().hashCode();
	}
}
