package com.cg.dca.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dca.entity.User;
import com.cg.dca.service.IUserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	IUserService service;

	
		
		@PostMapping("userLogin")
		public ResponseEntity<String> userLoginCheck(@Valid @RequestBody User userCredentials){
			
		String response =  service.checkLogin(userCredentials);
		return new ResponseEntity<String>(response,HttpStatus.OK);
		}
		

		@GetMapping("getLogins")
		public ResponseEntity<?> getAllUsers(){

		List<User> list = (List<User>) service.getAllUsers();
		return new ResponseEntity<Object>(list,HttpStatus.OK);
		}
		
		@GetMapping("{userId}")
		public ResponseEntity<User> getUserById(@PathVariable("userId") String userId){
			
		Optional<User> user = service.getUserById(userId);
        return new ResponseEntity<User>(user.get(),HttpStatus.OK);
		}
				
}
