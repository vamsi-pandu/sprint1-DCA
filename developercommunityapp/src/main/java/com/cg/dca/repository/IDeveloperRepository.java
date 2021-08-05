package com.cg.dca.repository;

import java.util.List;

import com.cg.dca.entity.Developer;
import com.cg.dca.exception.UnknownDeveloperException;

public interface IDeveloperRepository {

	Developer saveDeveloper(Developer dev);
	
	Developer updateDeveloper(Developer dev);
	
	Developer statusUpdate(Developer dev);
	
	Developer fetchDeveloper(int devId) throws UnknownDeveloperException;
	
	List<Developer> fetchAllDevelopers();
}
