package com.cg.dca.service;

import java.util.List;

import com.cg.dca.entity.Developer;
import com.cg.dca.exception.UnknownDeveloperException;

public interface IDeveloperService {

	Developer addDeveloper(Developer dev);
	
	Developer editDeveloper(Developer dev);
	
	Developer statusUpdate(Developer dev);	// Block/Unblock
	
	Developer getDeveloper(int devId) throws UnknownDeveloperException;
	
	List<Developer> getAllDevelopers();
}
