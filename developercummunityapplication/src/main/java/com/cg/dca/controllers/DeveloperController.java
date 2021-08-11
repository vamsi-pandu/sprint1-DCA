package com.cg.dca.controllers;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.dca.entity.Developer;
import com.cg.dca.exception.DeveloperAlreadyExistsException;
import com.cg.dca.exception.UnknownDeveloperException;
import com.cg.dca.service.IDeveloperServiceImpl;

@RestController
@RequestMapping("/developer")
public class DeveloperController {

	@Autowired
	IDeveloperServiceImpl service;

	@PostMapping("/addDeveloper")
	public ResponseEntity<String> addDeveloper(@RequestBody Developer dev) throws DeveloperAlreadyExistsException {
		service.addDeveloper(dev);
		return new ResponseEntity<String>("Developer Added Successfully", HttpStatus.OK);

	}

	@GetMapping("/getDeveloperById/{devId}")
	public ResponseEntity<Object> getDeveloper(@PathVariable int devId) throws UnknownDeveloperException {

		Optional<Developer> developer = service.getDeveloper(devId);

	

		return new ResponseEntity<Object>(developer.get(), HttpStatus.OK);

	}

	@PutMapping("/statusUpdate")
	public ResponseEntity<String> statusUpdate(@RequestBody Developer dev) {
		service.statusUpdate(dev);
		return new ResponseEntity<String>("Developer Updated Succesfully", HttpStatus.OK);

	}

	@PutMapping("/editDeveloper/{devId}")
	public ResponseEntity<String> editDeveloper(@RequestBody Developer dev, @PathVariable int devId)
			throws UnknownDeveloperException {
		service.editDeveloper(dev);
		return new ResponseEntity<String>("Developer Updated Succesfully", HttpStatus.OK);

	}

	@GetMapping("/getAllDeveloper")
	public ResponseEntity<?> getAllDevelopers() {
		List<Developer> list = (List<Developer>) service.getAllDevelopers();

		return new ResponseEntity<Object>(list, HttpStatus.OK);

	}


}
