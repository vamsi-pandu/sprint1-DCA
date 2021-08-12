package com.cg.dca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dca.entity.Developer;
import com.cg.dca.entity.SkillLevel;
import com.cg.dca.exception.UnknownDeveloperException;

@Repository
public interface IDeveloperRepository extends JpaRepository<Developer,Integer> {

	/*Developer saveDeveloper(Developer dev);
	
	Developer updateDeveloper(Developer dev);
	
	
	Developer statusUpdate(Developer dev);*/


	Optional<Developer> findById(int devId);
	
	Developer findByDevId(int devId);

	
	List<Developer> findAll();
	
	List<Developer> findAllBySkillLevel(SkillLevel  skillLevel);
	
}
