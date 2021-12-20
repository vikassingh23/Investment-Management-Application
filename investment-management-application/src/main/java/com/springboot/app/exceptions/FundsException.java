package com.springboot.app.exceptions;

public class FundsException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public FundsException (String message) {
		super(message);
	}
}
