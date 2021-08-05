package com.cg.dca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.dca.entity.Feed;
import com.cg.dca.exception.UnknownDeveloperException;
import com.cg.dca.exception.UnknownFeedException;

public interface IFeedRepository extends JpaRepository<Feed, Integer>{

	/*Feed saveFeed(Feed feed);
	
	Feed updateFeed(Feed feed);
	
	Feed likeFeed(int feedId) throws UnknownFeedException;
	
	Feed fetchFeed(int feedId) throws UnknownFeedException;
	
	Optional<Feed> deleteFeed(Optional<Feed> feed) throws UnknownFeedException;*/
	
	List<Feed> fetchFeedsByDeveloper(int devId) throws UnknownDeveloperException;
	
	List<Feed> fetchFeedsByKeyword(String keyword);
	
	List<Feed> fetchFeedsByTopic(String topic);

	
}
