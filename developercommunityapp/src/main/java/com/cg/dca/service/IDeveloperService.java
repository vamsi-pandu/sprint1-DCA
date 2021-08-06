package com.cg.dca.service;

import java.util.List;
import java.util.Optional;

import com.cg.dca.entity.Developer;
import com.cg.dca.exception.UnknownDeveloperException;


public interface IDeveloperService {

Optional<Developer> addDeveloper(Developer dev);
	
Optional<Developer> editDeveloper(Developer dev);
	
     String statusUpdate(Developer dev);	// Block/Unblock
	
Optional<Developer> getDeveloper(int devId) throws UnknownDeveloperException;
	
	List<Developer> getAllDevelopers();
}
