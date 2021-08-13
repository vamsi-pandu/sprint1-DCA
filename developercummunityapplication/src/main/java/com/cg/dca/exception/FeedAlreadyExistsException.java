package com.cg.dca.exception;

public class FeedAlreadyExistsException extends RuntimeException {  // made exceptions unchecked
	
	public FeedAlreadyExistsException(String message) {
		super(message);
	}

}
