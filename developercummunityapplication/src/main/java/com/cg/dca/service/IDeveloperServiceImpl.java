package com.cg.dca.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dca.entity.Developer;
import com.cg.dca.entity.Feed;
import com.cg.dca.entity.SkillLevel;
import com.cg.dca.entity.Topic;
import com.cg.dca.exception.DeveloperAlreadyExistsException;
import com.cg.dca.exception.UnknownDeveloperException;
import com.cg.dca.exception.UnknownFeedException;
import com.cg.dca.repository.IDeveloperRepository;



@Service
public class IDeveloperServiceImpl implements IDeveloperService   {
	
	//using the methods of crud repository
	@Autowired
	IDeveloperRepository devRepo;

	public IDeveloperServiceImpl(IDeveloperRepository developerRepo) {
		super();
		this.devRepo=developerRepo;
	}

	@Override
	//findById is Jpa repository method fetch data by primary key to check of its presence in database
	public Optional<Developer> addDeveloper(Developer dev) throws DeveloperAlreadyExistsException {
		Optional<Developer> existing = devRepo.findById(dev.getDevId());
		if (existing.isPresent()) {

			throw new DeveloperAlreadyExistsException("Developer With Id " + dev.getDevId() + " exists already");
		}
		devRepo.save(dev); // save is jpa repository method
		return existing;
	}

	@Override
	public Optional<Developer> editDeveloper(Developer dev) throws UnknownDeveloperException {
		Optional<Developer> existing = devRepo.findById(dev.getDevId());
		if (!(existing.isPresent())) {
			throw new UnknownDeveloperException("Developer With Id " + dev.getDevId() + " Not Exist");

		}
		devRepo.save(dev);
		return existing;
	}



	public Optional<Developer> getDeveloper(int devId) throws UnknownDeveloperException {
		Optional<Developer> dev = devRepo.findById(devId);
		if (!dev.isPresent())
			throw new UnknownDeveloperException("Developer With Id " + devId + " Not Found");
		return dev;
	}

	@Override
	public List<Developer> getAllDevelopers() {
		List<Developer> listOfDevelopers = (List<Developer>) devRepo.findAll(); // findAll is a jpa repository method fetch data from database
		return listOfDevelopers;

	}
	
	@Override
	public List<Developer> getDeveloperBySkillLevel(SkillLevel  skillLevel) {
		// findAllBySkillLevel is a method to check developer by SkillLevel 
		List<Developer> listOfDeveloperBySkill = devRepo.findAllBySkillLevel(skillLevel);
		if(listOfDeveloperBySkill.isEmpty())
			throw new UnknownFeedException("No feed found with topic "+skillLevel);
		return listOfDeveloperBySkill;
	}
	

}


	



