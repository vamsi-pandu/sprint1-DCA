package com.dca;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.dca.entity.Feed;
import com.cg.dca.repository.IFeedRepository;
import com.cg.dca.service.IFeedServiceImpl;

class IFeedServiceImplTest {

	@Autowired
	IFeedServiceImpl feedService;

	@Autowired
	IFeedRepository feedRepo;

	@Mock
	private IFeedServiceImpl mockService;


	List<Feed> mock = new ArrayList<>();

	@Test
	void listOfFeedByDevTest() {
		int myMethod   = feedService.getFeedsByDeveloper(2).size();
		int repoMethod = feedRepo.findAllByDeveloper_DevId(2).size();
		assertEquals(myMethod,repoMethod);
	}

	
	
	/*@Test
	void addFeedTest() {
		Feed feed = new Feed();
		feed.setFeedId(1000);
		feed.setQuery("what is java");
		feed.setRelevance(10);
		
		
      //   when(feedRepo.save(feed)).thenReturn(feed);
		
		//assertThat((mockService.addFeed(feed)).equals(feed); 
		}*/

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
