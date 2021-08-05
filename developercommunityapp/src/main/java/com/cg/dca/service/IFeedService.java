package com.cg.dca.service;

import java.util.List;
import java.util.Optional;

import com.cg.dca.entity.Feed;
import com.cg.dca.exception.UnknownDeveloperException;
import com.cg.dca.exception.UnknownFeedException;

public interface IFeedService {

	Feed addFeed(Feed feed) throws UnknownFeedException;
	
	Feed editFeed(Feed feed) throws UnknownFeedException;
	
	Feed likeFeed(int feedId) throws UnknownFeedException;
	
	Optional<Feed> getFeed(int feedId) throws UnknownFeedException;
	
	Optional<Feed> removeFeed(int feedId) throws UnknownFeedException;
	
	List<Feed> getFeedsByDeveloper(int devId) throws UnknownDeveloperException;
	
	List<Feed> getFeedsByKeyword(String keyword);
	
	List<Feed> getFeedsByTopic(String topic) throws UnknownFeedException;
}
