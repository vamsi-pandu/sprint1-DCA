package com.cg.dca.service;

import java.util.List;
import java.util.Optional;

import com.cg.dca.entity.Feed;
import com.cg.dca.entity.Topic;

public interface IFeedService {

    Optional<Feed> addFeed(Feed feed);
		
	Feed editFeed(Feed feed);
	
	Feed likeFeed(int feedId);
	
	Optional<Feed> getFeed(int feedId);
	
	Optional<Feed> removeFeed(int feedId);
	
	List<Feed> getFeedsByDeveloper(int devId);
	
	List<Feed> getFeedsByKeyword(String keyword);
	
	

	List<Feed> getFeedsByTopic(Topic topic);


	
}
