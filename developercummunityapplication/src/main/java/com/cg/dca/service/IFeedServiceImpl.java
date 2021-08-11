package com.cg.dca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dca.entity.Feed;
import com.cg.dca.entity.Topic;
import com.cg.dca.exception.FeedAlreadyFoundException;
import com.cg.dca.exception.UnknownDeveloperException;
import com.cg.dca.exception.UnknownFeedException;
import com.cg.dca.repository.IFeedRepository;

@Service
public class IFeedServiceImpl implements IFeedService{

	@Autowired
	IFeedRepository feedRepo;
	
	public IFeedServiceImpl(IFeedRepository feedRepo) {
		super();
		this.feedRepo = feedRepo;
	}

	/*@Override
	public Feed addFeed(Feed feed) {
		if(feedRepo.existsById(feed.getFeedId())) 
			throw new FeedAlreadyFoundException("Feed with "+feed.getFeedId()+" already exists");
		return feedRepo.save(feed);
	}*/
	@Override
	public Optional<Feed> addFeed(Feed feed) {
	Optional<Feed> newFeed = feedRepo.findById(feed.getFeedId());

	if(!newFeed.isPresent()) {
		feedRepo.save(feed);
		return newFeed;
	}
	throw new UnknownFeedException("Feed With Id "+ feed.getFeedId() +" exists already");

}

	@Override
	public Feed editFeed(Feed feed) {
		if(feedRepo.existsById(feed.getFeedId())) 
			return feedRepo.save(feed);
		else
			throw new UnknownFeedException("Feed with "+feed.getFeedId()+" does not exists");
	}

	
	@Override
	public Optional<Feed> getFeed(int feedId) {
		Optional<Feed> feed = feedRepo.findById(feedId);
		if(feed.isPresent())
		return feed;
		else
			throw new UnknownFeedException("Feed with "+feedId+" does not exists");
	}

	@Override
	public Optional<Feed> removeFeed(int feedId) {
		Optional<Feed> feed = feedRepo.findById(feedId);
		if(feed.isPresent()) {
			feedRepo.deleteById(feedId);
		    return feed;
		}
		else
			throw new UnknownFeedException("Feed with "+feedId+" does not exists");
	}

	@Override
	public List<Feed> getFeedsByDeveloper(int devId) {
		List<Feed> listOfFeedsByDev = feedRepo.findAllByDeveloper_DevId(devId);
		if(listOfFeedsByDev.isEmpty())
			throw new UnknownDeveloperException("No feed found for the developer with "+devId);
		return listOfFeedsByDev;
	}
	
	@Override
	public List<Feed> getFeedsByKeyword(String keyword) {
		List<Feed> listOfFeedByKeyword = feedRepo.findByKeyword(keyword);
		
		if(listOfFeedByKeyword.isEmpty())
			throw new UnknownFeedException("No feed with keyword "+keyword+" found");
		return listOfFeedByKeyword;
	}

	@Override
	public List<Feed> getFeedsByTopic(Topic topic) {
		List<Feed> listOfFeedByTopic = feedRepo.findAllByTopic(topic);
		if(listOfFeedByTopic.isEmpty())
			throw new UnknownFeedException("No feed found with topic "+topic);
		return listOfFeedByTopic;
	}

}
