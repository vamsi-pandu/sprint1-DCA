package com.cg.dca.controllers;


import java.util.List;


import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.jwt.JwtTokenUtil;

import com.cg.dca.entity.Developer;
import com.cg.dca.entity.Feed;
import com.cg.dca.entity.SkillLevel;
import com.cg.dca.entity.Topic;
import com.cg.dca.entity.User;
import com.cg.dca.exception.DeveloperAlreadyExistsException;
import com.cg.dca.exception.UnknownDeveloperException;
import com.cg.dca.service.IDeveloperServiceImpl;
import com.cg.jwt.JwtTokenUtil;
//@RestController is a specialized version of the controller. It includes the @Controller and @ResponseBody annotations
@RestController

//@RequestMapping annotation maps HTTP requests to handler methods of  REST controllers.
@RequestMapping("/developer")
@CrossOrigin(origins = "http://localhost:4200")
public class DeveloperController {

	@Autowired
	IDeveloperServiceImpl service;
	

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	User user = null;

	//@PostMapping annotated methods handle the HTTP POST requests matched with given URI expression.
	@PostMapping("/addDeveloper")
	public ResponseEntity<String> addDeveloper(@Valid @RequestBody Developer dev,HttpServletRequest request) throws DeveloperAlreadyExistsException {
		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);
		service.addDeveloper(dev);
		return new ResponseEntity<String>("Developer Added Successfully", HttpStatus.OK);

	}

	//@GetMapping annotated methods handle the HTTP GET requests matched with given URI expression
	@GetMapping("{devId}")
	public ResponseEntity<Object> getDeveloper(@PathVariable int devId,HttpServletRequest request) throws UnknownDeveloperException {
		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);
		Optional<Developer> developer = service.getDeveloper(devId);

	

		return new ResponseEntity<Object>(developer.get(), HttpStatus.OK);

	}

	//@GetMapping annotated methods handle the HTTP GET requests matched with given URI expression
	@GetMapping("/isBlocked/{devId}")
	public ResponseEntity<String> getStatus(@PathVariable("devId") int devId,HttpServletRequest request) {
		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);
		Optional<Developer> opt = service.getDeveloper(devId);
		if(!(opt.isPresent())){
				throw new UnknownDeveloperException("developer with Id "+devId+" not present");
		}
		Developer developer = opt.get();
		Boolean status = developer.getIsBlocked();
		
		if (status)
			return new ResponseEntity<String>("Developer With Id " + developer.getDevId() + " is Blocked",HttpStatus.OK);
		else
			return new  ResponseEntity<String>("Developer With Id " + developer.getDevId() + " Not Blocked",HttpStatus.OK);
		

	}

	//The PUT HTTP method is used to update the resource and @PutMapping annotation for mapping HTTP PUT requests onto specific handler methods.
	@PutMapping("/editDeveloper/{devId}")
	
	//@RequestBody annotation is used to indicating a method parameter should be bind to the body of the HTTP request.
	//@PathVariable annotation can be used to handle template variables in the request URI mapping, and set them as method parameters.
	public ResponseEntity<String> editDeveloper(@RequestBody Developer dev, @PathVariable int devId,HttpServletRequest request)
			throws UnknownDeveloperException {
		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);
		service.editDeveloper(dev);
		return new ResponseEntity<String>("Developer Updated Succesfully", HttpStatus.OK);

	}

	//@GetMapping annotated methods handle the HTTP GET requests matched with given URI expression
	@GetMapping("/getAllDeveloper")
	public ResponseEntity<?> getAllDevelopers(HttpServletRequest request) {
		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);
		List<Developer> list = (List<Developer>) service.getAllDevelopers();

		return new ResponseEntity<Object>(list, HttpStatus.OK);

	}
	
	//@GetMapping annotated methods handle the HTTP GET requests matched with given URI expression
	@GetMapping("/developer/{skillLevel}")
	public ResponseEntity<?> getDeveloperBySkill(@PathVariable("skillLevel") SkillLevel  skillLevel,HttpServletRequest request){
		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);
		List<Developer> listOfDeveloperBySkills = (List<Developer>) service.getDeveloperBySkillLevel(skillLevel);

		return new ResponseEntity<Object>(listOfDeveloperBySkills,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteDeveloper/{devId}")
		public ResponseEntity<?> deleteDeveloper(@PathVariable("devId") int devId,HttpServletRequest request){
		user = jwtTokenUtil.validateTokenAndGetUserDetails(request);
		service.deleteDeveloper(devId);
			return new ResponseEntity<String>("Developer Deleted Succesfully",HttpStatus.OK);
	}
	
	
	



}
