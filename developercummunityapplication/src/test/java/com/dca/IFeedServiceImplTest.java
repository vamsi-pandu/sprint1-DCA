package com.dca;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.dca.entity.Developer;
import com.cg.dca.entity.Feed;
import com.cg.dca.entity.Topic;
import com.cg.dca.exception.UnknownFeedException;
import com.cg.dca.repository.IFeedRepository;
import com.cg.dca.service.IFeedService;
import com.cg.dca.service.IFeedServiceImpl;

class IFeedServiceImplTest {
	
	IFeedRepository repo = Mockito.mock(IFeedRepository.class);
	
	IFeedService service = new IFeedServiceImpl(repo);
	
	@Test
	public void addFeedTest() {
		Feed feed = new Feed();
		feed.setFeedId(100);
		feed.setQuery("What is json");
		feed.setFeedTime(LocalDateTime.now());
		feed.setTopic(Topic.JAVA);
		feed.setTotalComments(2);
		
		when(repo.existsById(100)).thenReturn(true);
		assertEquals(2, feed.getTotalComments());
		
	}
	
	@Test
	public void removeFeedTest() {
		Feed feed = new Feed();
		feed.setFeedId(100);
		feed.setQuery("What is json");
		feed.setFeedTime(LocalDateTime.now());
		feed.setTopic(Topic.JAVA);
		
		feed.setTotalComments(0);
		
		try{
			Optional<Feed> e2=Optional.of(feed);
		
		when(repo.findById(200)).thenReturn(e2);
		when(repo.existsById(feed.getFeedId())).thenReturn(false);
		   assertFalse(repo.existsById(feed.getFeedId()));
		   
		}catch(UnknownFeedException ex) {
			fail("no feed with id exists");
		}
		
	}
	
	@Test
	public void getFeedByDevelopersTest() {
		Feed feed = new Feed();
		feed.setFeedId(100);
		feed.setQuery("What is json");
		feed.setFeedTime(LocalDateTime.now());
		feed.setTopic(Topic.JAVA);
		feed.setTotalComments(0);
		
		Developer developer = new Developer();
		developer.setDevId(100);
		
		feed.setDeveloper(developer);
		
		List<Feed> devList = new ArrayList<Feed>();
		devList.add(feed);
		
		when(repo.findAllByDeveloper_DevId(100)).thenReturn(devList);
		assertThat(service.getFeedsByDeveloper(100)).isEqualTo(devList);
	}
	
	@Test
	public void getFeedByTopicTest() {
		Feed q1 = new Feed();
		q1.setFeedId(1);
		q1.setTopic(Topic.JAVA);
		
		Feed q2 = new Feed();
		q2.setFeedId(2);
		q2.setTopic(Topic.TESTING);
		
		
		List<Feed> qList = new ArrayList<Feed>();
		qList.add(q1);
		qList.add(q2);

		when(repo.findAllByTopic(Topic.TESTING)).thenReturn(qList);
		assertThat(service.getFeedsByTopic(Topic.TESTING)).isEqualTo(qList);
	}
}
