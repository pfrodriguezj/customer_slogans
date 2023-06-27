package com.mango.customer.exception;



public class UserNotFoundException extends Exception{
	private String message = "User not found";

	@Override
	public String getMessage() {
		return message;
	}
}
