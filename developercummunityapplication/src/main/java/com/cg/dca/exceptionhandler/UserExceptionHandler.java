package com.cg.dca.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.dca.exception.UnknownFeedException;
import com.cg.dca.exception.UserNotFoundException;

@ControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(UnknownFeedException.class)
	public ResponseEntity<?> handleUserNotFound(UserNotFoundException unfe) {

	/*	Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("error", " failed");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());
*/
		return new ResponseEntity<>(unfe, HttpStatus.NOT_FOUND);
	}
}
