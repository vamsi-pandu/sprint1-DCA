package com.cg.dca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dca.entity.Developer;
import com.cg.dca.entity.Feed;
import com.cg.dca.entity.Topic;
import com.cg.dca.exception.FeedAlreadyExistsException;
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
	
	//Optional class: It is a public final class which is used to deal with NullPointerException in Java application.
    //It provides methods to check the presence of value for particular variable.
	
	
	// addFeed method is to add and save the feed details with feedId as primary key.
	// throws FeedAlreadyExistsException if feed with feedId already exists.
	@Override
	public Optional<Feed> addFeed(Feed feed) {
	Optional<Feed> optionalFeed = feedRepo.findById(feed.getFeedId());

	if(!optionalFeed.isPresent()) {
		feedRepo.save(feed);
		return optionalFeed;
	}
	throw new FeedAlreadyExistsException("Feed With Id "+ feed.getFeedId() +" exists already");

}

	//editFeed method is to edit the existing feed details
	// throws UnknownFeedException if feed details with given feedId does not exist.
	@Override
	public Feed editFeed(Feed feed) {
		if(feedRepo.existsById(feed.getFeedId())) 
			return feedRepo.save(feed);
		else
			throw new UnknownFeedException("Feed with "+feed.getFeedId()+" does not exists");
	}

	//getFeed method is to get feed details by providing feedId.
	//throws UnknownFeedException if feed details with given feedId does not exist.
	@Override
	public Optional<Feed> getFeed(int feedId) {
		Optional<Feed> optionalfFeed = feedRepo.findById(feedId);
		if(optionalfFeed.isPresent())
		return optionalfFeed;
		else
			throw new UnknownFeedException("Feed with "+feedId+" does not exists");
	}

	//removeFeed is to delete feed details by providing feedId
	//throws UnknownFeedException if feed details with given feedId does not exist.
	@Override
	public Optional<Feed> removeFeed(int feedId) {
		Optional<Feed> optionalFeed = feedRepo.findById(feedId);
		if(optionalFeed.isPresent()) {
			feedRepo.deleteById(feedId);
		    return optionalFeed;
		}
		else
			throw new UnknownFeedException("Feed with "+feedId+" does not exists");
	}

	//getFeedsByDeveloper method is to get list of feeds given by a developer by providing developer id.
	//throws UnknownFeedException if feed details with given devId is not found.
	@Override
	public List<Feed> getFeedsByDeveloper(int devId) {
		List<Feed> listOfFeedsByDev = feedRepo.findAllByDeveloper_DevId(devId);
		if(listOfFeedsByDev.isEmpty())
			throw new UnknownFeedException("No feed found for the developer with "+devId);
		return listOfFeedsByDev;
	}
	
	//getFeedsByKeyword method is to get list of feeds containing given keyword.
	//throws UnknownFeedException if feed details with given keyword is not found.
	@Override
	public List<Feed> getFeedsByKeyword(String keyword) {
		List<Feed> listOfFeedByKeyword = feedRepo.findByKeyword(keyword);
		
		if(listOfFeedByKeyword.isEmpty())
			throw new UnknownFeedException("No feed with keyword "+keyword+" found");
		return listOfFeedByKeyword;
	}

	//getFeedsByTopic method is to get list of feeds by given topic .
	//throws UnknownFeedException if feed details with given topic is not found.
	@Override
	public List<Feed> getFeedsByTopic(Topic topic) {
		List<Feed> listOfFeedByTopic = feedRepo.findAllByTopic(topic);
		if(listOfFeedByTopic.isEmpty())
			throw new UnknownFeedException("No feed found with topic "+topic);
		return listOfFeedByTopic;
	}

	@Override
	public List<Feed> getAllFeeds() {
		List<Feed> listOfFeeds = (List<Feed>) feedRepo.findAll(); // findAll is a jpa repository method fetch data from database
		return listOfFeeds;
		
	}

}
