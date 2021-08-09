package com.cg.dca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.dca.entity.User;
import com.cg.dca.exception.UserNotFoundException;
import com.cg.dca.repository.IUserRepository;

public class IUserServiceImpl implements IUserService{

	@Autowired
	private IUserRepository userRepo;
	
	

	
	@Override
	public List<User> getAllUsers() {
		
		List<User> listOfUsers = (List<User>) userRepo.findAll();
		return listOfUsers;
		
	}

	@Override
	public Optional<User> getUserById(String UserId) {
		Optional<User> user = userRepo.findById(UserId);
		if(!user.isPresent())
			throw new UserNotFoundException("User With Id "+ UserId+" Not Found");
		return user;
		
	}

	@Override
	public String checkLogin(User userCredentials) {
		User found = userRepo.findByUserIdAndPassword(userCredentials.getUserId(), userCredentials.getPassword());
		if(found == null)
			throw new UserNotFoundException("Incorrect User Name Or Password");
		
		return "Succesfully Logged In!!!";
		
	}

	/*@Override
	public User logout(User user) {
		
		return null;
	}*/

	



}
