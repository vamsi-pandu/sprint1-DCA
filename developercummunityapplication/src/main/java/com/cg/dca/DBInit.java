package com.cg.dca;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cg.dca.entity.Developer;
import com.cg.dca.entity.Feed;
import com.cg.dca.entity.Response;
import com.cg.dca.entity.SkillLevel;
import com.cg.dca.entity.Topic;
import com.cg.dca.entity.User;
import com.cg.dca.repository.IDeveloperRepository;
import com.cg.dca.repository.IFeedRepository;
import com.cg.dca.repository.IResponseRepository;
import com.cg.dca.repository.IUserRepository;

@Component
public class DBInit implements CommandLineRunner{

	@Autowired
	IUserRepository userRepo;
	@Autowired
	IDeveloperRepository devRepo;
	@Autowired
	IFeedRepository feedRepo;
	@Autowired
	IResponseRepository resRepo;
	
	Logger logger = LoggerFactory.getLogger(DBInit.class);
	
	@Override
	public void run(String... args) throws Exception {
		
		logger.info("H2 datbase product created");
		/*-----------------user entity--------------------*/
		User user = new User();
		
		user.setUserId("user1");
		user.setPassword("password1");
		user.setRole("senior_developer");
		userRepo.save(user);
		
		/*-----------------Developer entity----------------*/
		Developer dev = new Developer();
		
		dev.setDevId(100);
		dev.setEmail("raju@gmail.com");
		//dev.setFeedList(null);
		dev.setIsBlocked(false);
		dev.setIsVerified(true);
		dev.setMemberSince(LocalDate.of(2020, 9, 9));
		dev.setName("Raju");
		dev.setReputations(5);
		dev.setSkillLevel(SkillLevel.INTERMEDIATE);
		//dev.setTotalFeeds(1);
		dev.setUser(user);
		devRepo.save(dev);
		
		/*-----------------Feed entity----------------------*/
		Feed feed = new Feed();
		
		feed.setFeedId(100);
		feed.setQuery("What is Json");
		//feed.setFeedTime(LocalDateTime.now());
		//feed.setUpdateDateTime(updateDateTime);
		//feed.setResponses(null);
		feed.setTopic(Topic.JAVA);
		feed.setDeveloper(dev);
		feed.setTotalComments(2);
		feedRepo.save(feed);
		
		/*-----------------Response entity--------------------*/
		Response res = new Response();
		
		res.setRespId(12);
		//res.setResponseTime(LocalDateTime.now());
		//res.setUpdatedResponseDateTime(updatedResponseDateTime);
		res.setDeveloper(dev);
		res.setFeed(feed);
		res.setAnswer("JSON is javascript object notation");
		res.setAccuracy(5);
		resRepo.save(res);
		
		logger.info("all the entities are initialized");
	}

}
