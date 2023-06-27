package com.mango.customer.exception;

public class MaxSlogansReachedException extends Exception{
	private String message = "Maximum number of slogans has been reached";

	@Override
	public String getMessage() {
		return message;
	}
}
