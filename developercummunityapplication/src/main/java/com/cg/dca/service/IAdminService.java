package com.cg.dca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.dca.entity.Admin;
import com.cg.dca.entity.Developer;

@Service
public interface IAdminService {
	
	 List<Admin> getAllAdmins();
		Optional<Admin>  getAdminById(Integer adminId);
		Optional<Developer>  getDeveloperById(Integer devId);
		
		Developer  validateDeveloperById(Integer devId);
		Developer  invalidateDeveloperById(Integer devId);

}
