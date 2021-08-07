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
	IDeveloperRepository devRepos;

	@Override
	public Optional<Developer> addDeveloper(Developer dev) {
		Optional<Developer> exi = devRepos.findById(dev.getDevId());
		if(exi.isPresent()) {
			throw new DeveloperAlreadyExistsException ("Developer With Id"+dev.getDevId()+"Already exist");
		}
		devRepos.save(dev);
		return exi;
	}

	@Override
	public Optional <Developer> editDeveloper(Developer dev) {
		Optional<Developer> edit = devRepos.findById(dev.getDevId());
		if(!edit.isPresent()) {
			throw new UnknownDeveloperException("Developer With Id "+dev.getDevId()+" Not Exist");
		}
		devRepos.save(dev);
		return edit;
	}

	@Override
	public String statusUpdate(Developer dev) {
		boolean status =dev.getIsBlocked();
		if(status) 
			return "Developer With Id" + dev.getDevId()+"is Blocked";
		else
		return "Developer With Id" + dev.getDevId()+"is Not Blocked";
	}

	@Override
	public Optional<Developer> getDeveloper(int devId) throws UnknownDeveloperException {
		Optional<Developer> get = devRepos.findById(devId);
		if(!get.isPresent()) {
			throw new UnknownDeveloperException("Developer With Id "+devId+" Not Exist");
		}
		
		return get;
	}

	@Override
	public List<Developer> getAllDevelopers() {
		List<Developer> getall= devRepos.findAll();
		return getall;
	}
}


	



