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

@RestController
@RequestMapping("developerCommunity/response")
public class ResponseController {
	
	@Autowired
	IResponseService service;
	
	@PostMapping("save")
	public ResponseEntity<String> saveResponse(@RequestBody Response response) {
		service.addResponse(response);
		return new ResponseEntity<String>("Response added successfully",HttpStatus.OK);
	}
	
	@PutMapping("update")
	public ResponseEntity<String> updateResponse(@RequestBody Response response){
		service.editResponse(response);
		return new ResponseEntity<String>("Response updated successfully",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{respId}")
	public ResponseEntity<String> deleteResponse(@PathVariable("respId") int respId){
		service.removeResponse(respId);
		return new ResponseEntity<String>("Response with Id "+respId+" deleted successfully",HttpStatus.OK);
		
	}
	
	@GetMapping("/feed/{feedId}")
	public ResponseEntity<?> getResponseByFeed(@PathVariable("feedId") int feedId){
		List<Response> listOfResponses = service.getResponseByFeed(feedId); 
		return new ResponseEntity<Object>(listOfResponses,HttpStatus.OK);
	}
	
	@GetMapping("/developer/{devId}")
	public ResponseEntity<?> getResponseByDeveloper(@PathVariable("devId") int devId){
		List<Response> listOfResponses = service.getResponseByDeveloper(devId);
		return new ResponseEntity<Object>(listOfResponses,HttpStatus.OK);
	}
	

}
