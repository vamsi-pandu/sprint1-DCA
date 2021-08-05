package com.cg.dca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dca.entity.Feed;
import com.cg.dca.exception.UnknownDeveloperException;
import com.cg.dca.exception.UnknownFeedException;
import com.cg.dca.repository.IFeedRepository;

@Service
public class IFeedServiceImpl implements IFeedService{

	@Autowired
	IFeedRepository feedRepo;
	
	@Override
	public Feed addFeed(Feed feed) throws UnknownFeedException{
		if(feedRepo.existsById(feed.getFeedId())) 
			throw new UnknownFeedException("Feed with "+feed.getFeedId()+" already exists");
		return feedRepo.save(feed);
	}

	@Override
	public Feed editFeed(Feed feed) throws UnknownFeedException {
		if(feedRepo.existsById(feed.getFeedId())) 
			return feedRepo.save(feed);
		else
			throw new UnknownFeedException("Feed with "+feed.getFeedId()+" does not exists");
		
		
	}

	@Override
	public Feed likeFeed(int feedId) throws UnknownFeedException {
		
		return null;
	}

	@Override
	public Optional<Feed> getFeed(int feedId) throws UnknownFeedException {
		Optional<Feed> feed = feedRepo.findById(feedId);
		if(feed.isPresent())
		return feed;
		else
			throw new UnknownFeedException("Feed with "+feedId+" does not exists");
	}

	@Override
	public Optional<Feed> removeFeed(int feedId) throws UnknownFeedException {
		Optional<Feed> feed = feedRepo.findById(feedId);
		if(feed.isPresent()) {
			feedRepo.deleteById(feedId);
		    return feed;
		}
		else
			throw new UnknownFeedException("Feed with "+feedId+" does not exists");
	}

	@Override
	public List<Feed> getFeedsByDeveloper(int devId) throws UnknownDeveloperException {
		List<Feed> listOfFeedsByDev = feedRepo.fetchFeedsByDeveloper(devId);
		if(listOfFeedsByDev.isEmpty())
			throw new UnknownDeveloperException("No feed found for the developer with "+devId);
		return listOfFeedsByDev;
		
	}

	@Override
	public List<Feed> getFeedsByKeyword(String keyword) {
		
		return null;
	}

	@Override
	public List<Feed> getFeedsByTopic(String topic) throws UnknownFeedException {
		List<Feed> listOfFeedByTopic = feedRepo.fetchFeedsByTopic(topic);
		if(listOfFeedByTopic.isEmpty())
			throw new UnknownFeedException("No feed found with topic "+topic);
		return listOfFeedByTopic;
		
	}

}
