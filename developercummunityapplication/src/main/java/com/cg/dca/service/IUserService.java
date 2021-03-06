package com.cg.dca.service;

import java.util.List;
import java.util.Optional;

import com.cg.dca.entity.User;

public interface IUserService {
	

	
	Optional<User> addUser(User user);
	
    List<User> getAllUsers();
	
	Optional<User>  getUserById(String UserId);
	
	String checkLogin(User userCredentials);

	
}
