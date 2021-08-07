package com.cg.dca.controllers;

<<<<<<< Updated upstream
import java.util.List;
import java.util.Optional;

=======
>>>>>>> Stashed changes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
<<<<<<< Updated upstream
=======
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> Stashed changes

import com.cg.dca.entity.Developer;
import com.cg.dca.exception.DeveloperAlreadyExistsException;
import com.cg.dca.exception.UnknownDeveloperException;
import com.cg.dca.service.IDeveloperServiceImpl;
<<<<<<< Updated upstream


public class DeveloperController {

=======
import com.google.common.base.Optional;

import antlr.collections.List;


@RestController
@RequestMapping("/developer")
public class DeveloperController {
>>>>>>> Stashed changes
	@Autowired
	IDeveloperServiceImpl service;

	@PostMapping("/addDeveloper")
	public ResponseEntity<String> addDeveloper(@RequestBody Developer dev) throws DeveloperAlreadyExistsException {
		service.addDeveloper(dev);
		return new ResponseEntity<String>("Developer Added Successfully", HttpStatus.OK);

	}

	@GetMapping("/getDeveloperById/{devId}")
	public ResponseEntity<Object> getDeveloper(@PathVariable int devId) throws UnknownDeveloperException {
<<<<<<< Updated upstream
		Optional<Developer> developer = service.getDeveloper(devId);
=======
		Optional<Developer> developer = service.();
>>>>>>> Stashed changes
		return new ResponseEntity<Object>(developer.get(), HttpStatus.OK);

	}

	@PostMapping("/statusUpdate")
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

<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
}
