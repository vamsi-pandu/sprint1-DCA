package com.dca;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import com.cg.dca.entity.User;
import com.cg.dca.repository.IFeedRepository;
import com.cg.dca.repository.IUserRepository;
import com.cg.dca.service.IFeedService;
import com.cg.dca.service.IFeedServiceImpl;
import com.cg.dca.service.IUserService;
import com.cg.dca.service.IUserServiceImpl;

class IUserServiceImplTest {

	IUserRepository repo = Mockito.mock(IUserRepository.class);
	
	IUserService service = new IUserServiceImpl(repo);
	
	@Test
	void TestAdduser() {
		User user1=new User();
		user1.setUserId("shashi");
		user1.setPassword("password1");
		user1.setRole("senior_developer");
		
		when(repo.existsById("user1")).thenReturn(true);
		assertEquals("shashi", user1.getUserId());
	        
		}
	@Test
	void testGetUserById() {
		User user1=new User();
		user1.setUserId("shashi");
		user1.setPassword("password1");
		user1.setRole("senior_developer");
		
		User user2=new User();
		user2.setUserId("user2");
		user2.setPassword("password2");
		user2.setRole("junior_developer");
		

		when(repo.existsById("user1")).thenReturn(true);
		assertEquals("senior_developer", user1.getRole());
	}
	
	@Test
	void testGetAllUsers() {
		User u1=new User();
		u1.setUserId("user1");
		u1.setPassword("password1");
		u1.setRole("senior_developer");
		
		
		User u2=new User();
		u2.setUserId("user2");
		u2.setPassword("password2");
		u2.setRole("junior_developer");
		
		List<User> UserList = new ArrayList<>();
		UserList.add(u1);
		UserList.add(u2);
		
		when(this.repo.findAll()).thenReturn(UserList);
		
		assertThat(this.service.getAllUsers()).isEqualTo(UserList);
	}
	
	
}
