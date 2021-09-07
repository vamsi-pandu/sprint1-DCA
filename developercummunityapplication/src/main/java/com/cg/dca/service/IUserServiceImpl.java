package com.cg.dca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dca.entity.Feed;
import com.cg.dca.entity.User;
import com.cg.dca.exception.UnknownFeedException;
import com.cg.dca.exception.UserAlreadyExistException;
import com.cg.dca.exception.UserNotFoundException;
import com.cg.dca.repository.IUserRepository;

@Service
public class IUserServiceImpl implements IUserService{

	@Autowired
    IUserRepository userRepo;
	
	

	public IUserServiceImpl(IUserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public Optional<User> addUser(User user) {
		//findById method is used to find the user id in the database
		Optional<User> newUser = userRepo.findById(user.getUserId());

		if(!newUser.isPresent()) {
			userRepo.save(user);
			return newUser;
		}
		throw new UserAlreadyExistException("User With Id "+ user.getUserId() +" exists already");

		
	}

	
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


}
