package com.cg.dca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dca.entity.Response;
import com.cg.dca.service.IResponseService;

//@RestController is a specialized version of the controller. It includes the @Controller and @ResponseBody annotations
@RestController

//@RequestMapping annotation maps HTTP requests to handler methods of  REST controllers.
@RequestMapping("developerCommunity/response")
public class ResponseController {
	
	@Autowired
	IResponseService service;
	
	//@PostMapping annotated methods handle the HTTP POST requests matched with given URI expression.
	@PostMapping("save")
	public ResponseEntity<String> saveResponse(@RequestBody Response response) {
		service.addResponse(response);
		return new ResponseEntity<String>("Response added successfully",HttpStatus.OK);
	}
	
	//The PUT HTTP method is used to update the resource and @PutMapping annotation for mapping HTTP PUT requests onto specific handler methods.
	@PutMapping("update")
	//@RequestBody annotation is used to indicating a method parameter should be bind to the body of the HTTP request.
	public ResponseEntity<String> updateResponse(@RequestBody Response response){
		
		service.editResponse(response);
		return new ResponseEntity<String>("Response updated successfully",HttpStatus.OK);
		
	}
	
	//The DELETE HTTP method is used to delete the resource and @DeleteMapping annotation for mapping HTTP DELETE requests onto specific handler methods.
	@DeleteMapping("/delete/{respId}")
	public ResponseEntity<String> deleteResponse(@PathVariable("respId") int respId){
		
		service.removeResponse(respId);
		return new ResponseEntity<String>("Response with Id "+respId+" deleted successfully",HttpStatus.OK);
		
	}
	//@GetMapping annotated methods handle the HTTP GET requests matched with given URI expression
	@GetMapping("/feed/{feedId}")
	public ResponseEntity<?> getResponseByFeed(@PathVariable("feedId") int feedId){
		
		List<Response> listOfResponses = service.getResponseByFeed(feedId); 
		return new ResponseEntity<Object>(listOfResponses,HttpStatus.OK);
		
	}
	
	@GetMapping("/developer/{devId}")
	//@PathVariable annotation can be used to handle template variables in the request URI mapping, and set them as method parameters.
	public ResponseEntity<?> getResponseByDeveloper(@PathVariable("devId") int devId){
		
		List<Response> listOfResponses = service.getResponseByDeveloper(devId);
		return new ResponseEntity<Object>(listOfResponses,HttpStatus.OK);
		
	}
	

}
