package com.cg.dca.exception;

public class FeedAlreadyFoundException extends RuntimeException {  // made exceptions unchecked
	
	public FeedAlreadyFoundException(String message) {
		super(message);
	}

}
