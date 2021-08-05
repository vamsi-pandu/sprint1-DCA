package com.cg.dca.service;

import com.cg.dca.entity.User;

public interface IUserService {
	
	User login(User user);
	
	User logout(User user);
}
