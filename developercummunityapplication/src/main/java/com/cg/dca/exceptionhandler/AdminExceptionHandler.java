package com.cg.dca.exceptionhandler;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.dca.exception.AdminNotFoundException;

@ControllerAdvice
public class AdminExceptionHandler {
	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<?> handleAdminDataError(AdminNotFoundException e){
			
			Map<String,Object> error = new LinkedHashMap<>();
			
			error.put("error","Retreive failed for this admin");
			error.put("message", e.getMessage());
			error.put("timeStamp", LocalDate.now().toString());
			return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);		
			
		}

}
