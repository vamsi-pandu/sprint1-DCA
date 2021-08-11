package com.cg.dca.exceptionhandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.dca.exception.UserAlreadyExistException;
import com.cg.dca.exception.UserNotFoundException;

@ControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> handleEmployeeDataError(UserNotFoundException unfe){
		
		Map<String,Object> error = new LinkedHashMap<>();
		
		error.put("error","Retrieve failed for this user");
		error.put("message", unfe.getMessage());
		error.put("timeStamp", LocalDate.now().toString());
		return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);		
		
	}
	
	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<?> handleFeed(UserAlreadyExistException uaex) {

		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("error", " failed to add the user");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", uaex.getMessage());

		return new ResponseEntity<Object>(errorBody, HttpStatus.NOT_FOUND);
	}

}
