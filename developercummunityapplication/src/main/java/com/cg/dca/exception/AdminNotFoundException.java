package com.cg.dca.exception;



public class AdminNotFoundException extends RuntimeException{
	public AdminNotFoundException(String message) {
		super(message);
	}
}
