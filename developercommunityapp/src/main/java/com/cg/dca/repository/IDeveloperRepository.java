package com.cg.dca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.dca.entity.Developer;
import com.cg.dca.exception.UnknownDeveloperException;

public interface IDeveloperRepository extends JpaRepository<Developer,Integer> {

	Developer saveDeveloper(Developer dev);
	
	Developer updateDeveloper(Developer dev);
	
	Developer statusUpdate(Developer dev);
	
	Developer fetchDeveloper(int devId) throws UnknownDeveloperException;
	
	
	List<Developer> fetchAllDevelopers();
	
}
