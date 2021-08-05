package com.cg.dca.repository;

import com.cg.dca.entity.User;

public interface IUserRepository {
	
	User login(User user);
	
	User logout(User user);
}
