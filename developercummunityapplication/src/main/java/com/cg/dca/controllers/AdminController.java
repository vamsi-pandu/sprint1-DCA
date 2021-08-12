package com.cg.dca.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dca.entity.Admin;
import com.cg.dca.entity.Developer;
import com.cg.dca.service.IAdminService;
import com.cg.dca.service.IAdminServiceImpl;

@RestController
@RequestMapping("adminCommunity")
public class AdminController {
	@Autowired
	IAdminService service;

	@GetMapping("getAdmin")
	public ResponseEntity<?> getAdmins(){

		List<Admin> list = (List<Admin>) service.getAllAdmins();
		return new ResponseEntity<Object>(list,HttpStatus.OK);
	}

	@GetMapping("{adminId}")
	public ResponseEntity<Object> getAdminById(@PathVariable("adminId") Integer adminId){
		Optional<Admin> admin = service.getAdminById(adminId);

		return new ResponseEntity<Object>(admin.get(),HttpStatus.OK);
	}
	
	@GetMapping("getDev/{devId}")
	public ResponseEntity<Object> getDeveloper(@PathVariable("devId") Integer devId){ 
		Optional<Developer>developer = service.getDeveloperById(devId);
		return new ResponseEntity<Object>(developer.get(),HttpStatus.OK);
		
	}

	
	@GetMapping("getDev/{devId}/validate")
	public ResponseEntity<Object> validateDeveloper(@PathVariable("devId") Integer devId){ 
		Developer developer = service.validateDeveloperById(devId);
		return new ResponseEntity<Object>(developer,HttpStatus.OK);
		
	}
	
	@GetMapping("getDev/{devId}/invalidate")
	public ResponseEntity<Object> invalidateDeveloper(@PathVariable("devId") Integer devId){ 
		Developer developer = service.invalidateDeveloperById(devId);
		return new ResponseEntity<Object>(developer,HttpStatus.OK);
	

}
}