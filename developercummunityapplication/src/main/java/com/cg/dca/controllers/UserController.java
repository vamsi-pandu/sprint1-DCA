 package com.cg.dca.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dca.entity.User;
import com.cg.dca.service.IUserService;

//@RestController is a specialized version of the controller. It includes the @Controller and @ResponseBody annotations
@RestController

//@RequestMapping annotation maps HTTP requests to handler methods of  REST controllers.
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	IUserService service;

	    //@PostMapping annotated methods handle the HTTP POST requests matched with given URI expression.
    	//@RequestBody annotation is used to indicating a method parameter should be bind to the body of the HTTP request.
	    @PostMapping("/adduser")
     	public ResponseEntity<?> addUser(@Valid @RequestBody User user) {       
		service.addUser(user);
		return new  ResponseEntity<String>("User added successfully",HttpStatus.OK);
	    }

		
		@PostMapping("userLogin")
		public ResponseEntity<String> userLoginCheck(@Valid @RequestBody User userCredentials){
			
		String response =  service.checkLogin(userCredentials);
		return new ResponseEntity<String>(response,HttpStatus.OK);
		}
		

		//@GetMapping annotated methods handle the HTTP GET requests matched with given URI expression
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
