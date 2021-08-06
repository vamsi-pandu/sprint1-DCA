package com.cg.dca.service;

import java.util.List;

import com.cg.dca.entity.User;
import com.google.common.base.Optional;

public interface IUserService {
	
/*	User login(User user);
	
	User logout(User user);
	*/
List<User> getAllUsers();
	
	Optional<User>  getUserById(String UserId);
	
	String checkLogin(User userCredentials);
}
