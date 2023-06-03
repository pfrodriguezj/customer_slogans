package com.mango.customer.model;


public class Slogan {
	private String email;

	private String slogan;

	public Slogan() {
	}

	public Slogan(String email, String slogan) {
		this.email = email;
		this.slogan = slogan;
	}

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
