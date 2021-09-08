package com.cg.dca;

import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cg.dca.entity.Admin;
import com.cg.dca.entity.Developer;
import com.cg.dca.entity.Feed;
import com.cg.dca.entity.Response;
import com.cg.dca.entity.SkillLevel;
import com.cg.dca.entity.Topic;
import com.cg.dca.entity.User;
import com.cg.dca.repository.IAdminRepository;
import com.cg.dca.repository.IDeveloperRepository;
import com.cg.dca.repository.IFeedRepository;
import com.cg.dca.repository.IResponseRepository;
import com.cg.dca.repository.IUserRepository;

//CommandLineRunner bean can be used to execute any code at the start of the application
//DBInit class is to provide initial values in the database when springboot runs
@Component
public class DBInit implements CommandLineRunner{
	                          
	@Autowired
	IAdminRepository adminRepo;
	
	
	@Autowired
	IUserRepository userRepo;
	@Autowired
	IDeveloperRepository developerRepo;
	@Autowired
	IFeedRepository feedRepo;
	@Autowired
	IResponseRepository responseRepo;
	
	Logger logger = LoggerFactory.getLogger(DBInit.class);
	 //  to log messages for a specific system or application component
	
	@Override
	public void run(String... args) throws Exception {
		
		logger.info("H2 datbase product created");
		

		
		Admin admin = new Admin();
		admin.setAdId(1);
		admin.setAdName("Azmath");
		admin.setAdPassword("123456789");
		admin.setAdUser("azzu1");
		adminRepo.save(admin);
		
		
		
		
		
		
		User user = new User();
		
		user.setUserId("user1");
		user.setPassword("password1");
		user.setRole("senior_developer");
		userRepo.save(user);
		
		
		Developer developer1 = new Developer();
		
		developer1.setDevId(100);
		developer1.setEmail("raju@gmail.com");
		//dev.setFeedList(null);
		developer1.setIsBlocked(false);
		developer1.setIsVerified(true);
		developer1.setMemberSince(LocalDate.of(2020, 9, 9));
		developer1.setName("Raju");
		developer1.setSkillLevel(SkillLevel.INTERMEDIATE);
		//dev.setTotalFeeds(1);
		developer1.setUser(user);
		developerRepo.save(developer1);
		
		
		Feed feed1 = new Feed();
		
		//feed.setFeedId(10);
		feed1.setQuery("What is Json");
		//feed.setFeedTime(LocalDateTime.now());
		//feed.setUpdateDateTime(updateDateTime);
		//feed.setResponses(null);
		feed1.setTopic(Topic.JAVA);
		feed1.setDeveloper(developer1);
		feed1.setTotalComments(2);
		feedRepo.save(feed1);
		
		
		Response response1 = new Response();
		
		//response.setRespId(12);
		//res.setResponseTime(LocalDateTime.now());
		//res.setUpdatedResponseDateTime(updatedResponseDateTime);
		response1.setDeveloper(developer1);
		response1.setFeed(feed1);
		response1.setAnswer("JSON is javascript object notation");
		responseRepo.save(response1);
		

		
		Admin admin2 = new Admin();
		admin2.setAdId(2);
		admin2.setAdName("Pawan");
		admin2.setAdPassword("123456780");
		admin2.setAdUser("pawan1");
		adminRepo.save(admin2);
		
		
		
		
	
		User user2 = new User();
		
		user2.setUserId("user2");
		user2.setPassword("password2");
		user2.setRole("junior_developer");
		userRepo.save(user2);
		
		
		Developer developer2 = new Developer();
		
		developer2.setDevId(200);
		developer2.setEmail("sai@gmail.com");
		//dev.setFeedList(null);
		developer2.setIsBlocked(false);
		developer2.setIsVerified(true);
		developer2.setMemberSince(LocalDate.of(2019, 10, 9));
		developer2.setName("Sai");
		developer2.setSkillLevel(SkillLevel.INTERMEDIATE);
		//dev.setTotalFeeds(1);
		developer2.setUser(user2);
		developerRepo.save(developer2);
		
		
		Feed feed2 = new Feed();
		
		//feed.setFeedId(10);
		feed2.setQuery("What is js");
		//feed.setFeedTime(LocalDateTime.now());
		//feed.setUpdateDateTime(updateDateTime);
		//feed.setResponses(null);
		feed2.setTopic(Topic.PROGRAMMING);
		feed2.setDeveloper(developer1);
		feed2.setTotalComments(2);
		feedRepo.save(feed2);
		
		
		Response response2 = new Response();
		
		//response.setRespId(12);
		//res.setResponseTime(LocalDateTime.now());
		//res.setUpdatedResponseDateTime(updatedResponseDateTime);
		response2.setDeveloper(developer2);
		response2.setFeed(feed1);
		response2.setAnswer("js is javascript");
		responseRepo.save(response2);
		
		
		Feed feed3 = new Feed();
		
		//feed.setFeedId(10);
		feed3.setQuery("What is Junit");
		//feed.setFeedTime(LocalDateTime.now());
		//feed.setUpdateDateTime(updateDateTime);
		//feed.setResponses(null);
		feed3.setTopic(Topic.TESTING);
		feed3.setDeveloper(developer1);
		feed3.setTotalComments(2);
		feedRepo.save(feed3);

		
		
		
	
		Response response3 = new Response();
		
		//response.setRespId(12);
		//res.setResponseTime(LocalDateTime.now());
		//res.setUpdatedResponseDateTime(updatedResponseDateTime);
		response3.setDeveloper(developer1);
		response3.setFeed(feed3);
		response3.setAnswer("Junit is for testing java methods");
		responseRepo.save(response3);

	
		
		
		
	
		Feed feed4 = new Feed();
		
		//feed.setFeedId(10);
		feed4.setQuery("What is Json");
		//feed.setFeedTime(LocalDateTime.now());
		//feed.setUpdateDateTime(updateDateTime);
		//feed.setResponses(null);
		feed4.setTopic(Topic.JAVA);
		feed4.setDeveloper(developer2);
		feed4.setTotalComments(1);
		feedRepo.save(feed4);
		
	
		Response response4 = new Response();
		
		//response.setRespId(12);
		//res.setResponseTime(LocalDateTime.now());
		//res.setUpdatedResponseDateTime(updatedResponseDateTime);
		response4.setDeveloper(developer1);
		response4.setFeed(feed4);
		response4.setAnswer("JSON is javascript object notation");
		responseRepo.save(response4);
		
	
		
		
		
		
		
		User user3 = new User();
		
		user3.setUserId("user3");
		user3.setPassword("password3");
		user3.setRole("analyst");
		userRepo.save(user3);
		
	
		Developer developer3 = new Developer();
		
		developer3.setDevId(300);
		developer3.setEmail("kumar@gmail.com");
		//dev.setFeedList(null);
		developer3.setIsBlocked(false);
		developer3.setIsVerified(true);
		developer3.setMemberSince(LocalDate.of(2020, 9, 9));
		developer3.setName("Kumar");
		developer3.setSkillLevel(SkillLevel.BEGINNER);
		//dev.setTotalFeeds(1);
		developer3.setUser(user3);
		developerRepo.save(developer3);
		
		
		Feed feed5 = new Feed();
		
		//feed.setFeedId(10);
		feed5.setQuery("What is SPA");
		//feed.setFeedTime(LocalDateTime.now());
		//feed.setUpdateDateTime(updateDateTime);
		//feed.setResponses(null);
		feed5.setTopic(Topic.PROGRAMMING);
		feed5.setDeveloper(developer3);
		feed5.setTotalComments(2);
		feedRepo.save(feed5);
		
		
		Response response5 = new Response();
		
		//response.setRespId(12);
		//res.setResponseTime(LocalDateTime.now());
		//res.setUpdatedResponseDateTime(updatedResponseDateTime);
		response5.setDeveloper(developer3);
		response5.setFeed(feed5);
		response5.setAnswer("SPA is a single page application");
		responseRepo.save(response5);
		
		logger.info("all the entities are initialized");
	}

}
