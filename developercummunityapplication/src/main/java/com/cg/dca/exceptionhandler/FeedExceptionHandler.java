package com.cg.dca.exceptionhandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.dca.exception.FeedAlreadyFoundException;
import com.cg.dca.exception.UnknownFeedException;

@ControllerAdvice
public class FeedExceptionHandler {
	
	@ExceptionHandler(UnknownFeedException.class)
	public ResponseEntity<?> handleUnknownFeed(UnknownFeedException ex) {

	    Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("error", " failed");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());

		return new ResponseEntity<Object>(errorBody, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(FeedAlreadyFoundException.class)
	public ResponseEntity<?> handleFeed(FeedAlreadyFoundException ex) {

		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("error", " failed");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());

		return new ResponseEntity<Object>(errorBody, HttpStatus.BAD_REQUEST);
	}

}
