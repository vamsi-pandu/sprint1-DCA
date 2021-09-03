package com.cg.dca.service;

import java.util.List;
import java.util.Optional;

import com.cg.dca.entity.Developer;
import com.cg.dca.entity.Feed;
import com.cg.dca.entity.Topic;

public interface IFeedService {

    Optional<Feed> addFeed(Feed feed);         //  save new feed
		
	Feed editFeed(Feed feed);                 //  update the existing feed
	
	Optional<Feed> getFeed(int feedId);         //  get feed by feedId
	
	Optional<Feed> removeFeed(int feedId);
	
	List<Feed> getAllFeeds();
	
	List<Feed> getFeedsByDeveloper(int devId);      //  list all feed with same developerId
	
	List<Feed> getFeedsByKeyword(String keyword);    //  list all feeds having given keyword
	
	List<Feed> getFeedsByTopic(Topic topic);         //  list all feeds with given topic name

}
