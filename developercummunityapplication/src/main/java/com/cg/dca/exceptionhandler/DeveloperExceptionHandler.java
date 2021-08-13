package com.cg.dca.exceptionhandler;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.dca.exception.DeveloperAlreadyExistsException;
import com.cg.dca.exception.UnknownDeveloperException;

//@ControllerAdvice is a specialization of the @Component annotation which allows to handle exceptions across the whole application in one global handling component.
@ControllerAdvice
public class DeveloperExceptionHandler {
	
	//@ExceptionHandler annotation indicates which type of Exception we want to handle
	@ExceptionHandler(DeveloperAlreadyExistsException.class)
	
	//ResponseEntity gives the response status for the Http Request
	public ResponseEntity<?> handleDeveloperDataError(DeveloperAlreadyExistsException e) {

		Map<String, Object> error = new LinkedHashMap<>();

		error.put("error", "Developer Already Exists");
		error.put("message", e.getMessage());
		error.put("timeStamp", LocalDate.now().toString());
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(UnknownDeveloperException.class)
	public ResponseEntity<?> handleDeveloperDataError(UnknownDeveloperException e) {

		Map<String, Object> error = new LinkedHashMap<>();

		error.put("error", "Developer Not Found");
		error.put("message", e.getMessage());
		error.put("timeStamp", LocalDate.now().toString());
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);

	}

}
