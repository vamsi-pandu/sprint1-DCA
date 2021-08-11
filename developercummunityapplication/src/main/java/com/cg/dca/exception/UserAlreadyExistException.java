package com.cg.dca.exception;

public class UserAlreadyExistException extends RuntimeException{
 public UserAlreadyExistException(String message) {
	 super(message);
 }
}
