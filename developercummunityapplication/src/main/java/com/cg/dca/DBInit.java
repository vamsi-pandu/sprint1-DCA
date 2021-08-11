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
	
	@Override
	public void run(String... args) throws Exception {
		
		logger.info("H2 datbase product created");
		
		/*-----------------Admin entity--------------------*/
		
		Admin admin = new Admin();
		admin.setAdId(1);
		admin.setAdName("Azmath");
		admin.setAdPassword("1234");
		admin.setAdUser("azzu");
		adminRepo.save(admin);
		
		
		
		
		
		/*-----------------user entity--------------------*/
		User user = new User();
		
		user.setUserId("user1");
		user.setPassword("password1");
		user.setRole("senior_developer");
		userRepo.save(user);
		
		/*-----------------Developer entity----------------*/
		Developer developer = new Developer();
		
		developer.setDevId(100);
		developer.setEmail("raju@gmail.com");
		//dev.setFeedList(null);
		developer.setIsBlocked(false);
		developer.setIsVerified(true);
		developer.setMemberSince(LocalDate.of(2020, 9, 9));
		developer.setName("Raju");
		developer.setReputations(5);
		developer.setSkillLevel(SkillLevel.INTERMEDIATE);
		//dev.setTotalFeeds(1);
		developer.setUser(user);
		developerRepo.save(developer);
		
		/*-----------------Feed entity----------------------*/
		Feed feed = new Feed();
		
		//feed.setFeedId(10);
		feed.setQuery("What is Json");
		//feed.setFeedTime(LocalDateTime.now());
		//feed.setUpdateDateTime(updateDateTime);
		//feed.setResponses(null);
		feed.setTopic(Topic.JAVA);
		feed.setDeveloper(developer);
		feed.setTotalComments(2);
		feedRepo.save(feed);
		
		/*-----------------Response entity--------------------*/
		Response response = new Response();
		
		//response.setRespId(12);
		//res.setResponseTime(LocalDateTime.now());
		//res.setUpdatedResponseDateTime(updatedResponseDateTime);
		response.setDeveloper(developer);
		response.setFeed(feed);
		response.setAnswer("JSON is javascript object notation");
		responseRepo.save(response);
		
		logger.info("all the entities are initialized");
	}

}
