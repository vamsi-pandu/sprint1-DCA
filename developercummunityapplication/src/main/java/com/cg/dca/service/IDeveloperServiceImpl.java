package com.cg.dca.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dca.entity.Developer;
import com.cg.dca.exception.DeveloperAlreadyExistsException;
import com.cg.dca.exception.UnknownDeveloperException;
import com.cg.dca.repository.IDeveloperRepository;



@Service
public class IDeveloperServiceImpl implements IDeveloperService   {
	
	@Autowired
	IDeveloperRepository devRepo;

	@Override
	public Optional<Developer> addDeveloper(Developer dev) throws DeveloperAlreadyExistsException {
		Optional<Developer> existing = devRepo.findById(dev.getDevId());
		if (existing.isPresent()) {

			throw new DeveloperAlreadyExistsException("Developer With Id " + dev.getDevId() + " exists already");
		}
		devRepo.save(dev);
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

	@Override
	public String statusUpdate(Developer dev) {
		boolean checkStatus = dev.getIsBlocked();
		if (checkStatus)
			return "Developer With Id " + dev.getDevId() + " is Blocked";
		else
			return "Developer With Id " + dev.getDevId() + " Not Blocked";
	}

	public Optional<Developer> getDeveloper(int devId) throws UnknownDeveloperException {
		Optional<Developer> dev = devRepo.findById(devId);
		if (!dev.isPresent())
			throw new UnknownDeveloperException("Developer With Id " + devId + " Not Found");
		return dev;
	}

	@Override
	public List<Developer> getAllDevelopers() {
		List<Developer> listOfDevelopers = (List<Developer>) devRepo.findAll();
		return listOfDevelopers;

	}

}


	



