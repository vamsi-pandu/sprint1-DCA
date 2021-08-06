package com.cg.dca.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.dca.entity.Developer;
import com.cg.dca.exception.DeveloperAlreadyExistsException;
import com.cg.dca.exception.UnknownDeveloperException;
import com.cg.dca.repository.IDeveloperRepository;




public class IDeveloperServiceImpl implements IDeveloperService   {
	
	@Autowired
	IDeveloperRepository devrepos;

	@Override
	public Optional<Developer> addDeveloper(Developer dev) {
		Optional<Developer> exi = devrepos.findById(dev.getDevId());
		if(exi.isPresent()) {
			throw new DeveloperAlreadyExistsException ("Developer With Id"+dev.getDevId()+"Already exist");
		}
		devrepos.save(dev);
		return exi;
	}

	@Override
	public Optional <Developer> editDeveloper(Developer dev) {
		Optional<Developer> edit = devrepos.findById(dev.getDevId());
		if(!edit.isPresent()) {
			throw new UnknownDeveloperException("Developer With Id "+dev.getDevId()+" Not Exist");
		}
		devrepos.save(dev);
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
		Optional<Developer> get = devrepos.findById(devId);
		if(!get.isPresent()) {
			throw new UnknownDeveloperException("Developer With Id "+devId+" Not Exist");
		}
		
		return get;
	}

	@Override
	public List<Developer> getAllDevelopers() {
		List<Developer> getall= devrepos.findAll();
		return getall;
	}


	
}


	



