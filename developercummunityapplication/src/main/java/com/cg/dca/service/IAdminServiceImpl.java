package com.cg.dca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dca.entity.Admin;
import com.cg.dca.entity.Developer;
import com.cg.dca.exception.AdminNotFoundException;
import com.cg.dca.exception.UnknownDeveloperException;
import com.cg.dca.repository.IAdminRepository;
import com.cg.dca.repository.IDeveloperRepository;

@Service
public class IAdminServiceImpl implements IAdminService {
	
@Autowired 
IAdminRepository adminRepo;
	
	@Autowired
	IDeveloperRepository devRepo;

	@Override
	public List<Admin> getAllAdmins() {
		List<Admin> listOfAdmins = (List<Admin>) adminRepo.findAll();
		return listOfAdmins;
	}

	@Override
	public Optional<Admin> getAdminById(Integer adminId) {
		Optional<Admin> admin = adminRepo.findById(adminId);
		if(!admin.isPresent())
			throw new AdminNotFoundException("Admin With Id "+ adminId+" Not Found");
		return admin;
	}

	@Override
	public Optional<Developer> getDeveloperById(Integer devId) {
		Optional<Developer> developer = devRepo.findById(devId);
		
		  if(!developer.isPresent()) throw new
	 UnknownDeveloperException("Developer With Id "+ devId+" Not Found");
		 
		return developer;
	}

	@Override
	public Developer validateDeveloperById(Integer devId) {
		Developer exists = devRepo.findByDevId(devId);
		 if(exists == null)
		throw  new AdminNotFoundException("Devloper With Id "+ devId+" Not Found");
	boolean value = exists.getIsVerified();
	
		 if(!value) {
			  
			  exists.setIsVerified(true);
		 	  devRepo.save(exists);
		 }
		 else 
			 throw new AdminNotFoundException("Devloper With Id "+ devId+" Is Already Validated");
			 
		return exists;
	}

	@Override
	public Developer invalidateDeveloperById(Integer devId) {
		Developer exists = devRepo.findByDevId(devId);
		 if(exists == null)
		throw  new AdminNotFoundException("Devloper With Id "+ devId+" Not Found");
	boolean value = exists.getIsVerified();
	
		 if(value) {
			  exists.setIsVerified(false);
		 	  devRepo.save(exists);
		 }
		 else 
			 throw new AdminNotFoundException("Devloper With Id "+ devId+" Is Already Invalid");
		return exists;
				
	}
	}
	
	

