package com.cg.dca.exception;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(String msg){
		super(msg);
	}
}
