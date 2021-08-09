package com.cg.dca;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.dca.entity.Feed;
import com.cg.dca.repository.IFeedRepository;
import com.cg.dca.service.IFeedService;

@SpringBootTest
@RunWith(SpringRunner.class)
class IFeedServiceImplTest {

	@Autowired
	IFeedService feedService;
	
	@MockBean
	IFeedRepository feedRepo;
	
	@Test
	void testAddFeed() {
		Feed f1 = new Feed();
		f1.setFeedId(12);
		f1.setQuery("Why we use JSONIGNORE annotation");
		f1.setFeedDate(LocalDate.now());
		f1.setFeedTime(LocalTime.now());
		f1.setTopic("Java");
		f1.setRelevance(5);
		f1.setTotalComments(10);
		
        Mockito.when(feedRepo.save(f1)).thenReturn(f1);
		
		assertThat(feedService.addFeed(f1)).isEqualTo(f1);
	}
	
	@Test
	void testEditFeed() {
		Feed f1 = new Feed();
		f1.setFeedId(12);
		f1.setQuery("Why we use JSONIGNORE annotation");
		f1.setFeedDate(LocalDate.now());
		f1.setFeedTime(LocalTime.now());
		f1.setTopic("Java");
		f1.setRelevance(5);
		f1.setTotalComments(10);
		
		
		
	}
	
	@Test
	void testRemoveFeed() {
		Feed f1 = new Feed();
		f1.setFeedId(12);
		f1.setQuery("Why we use JSONIGNORE annotation");
		f1.setFeedDate(LocalDate.now());
		f1.setFeedTime(LocalTime.now());
		f1.setTopic("Java");
		f1.setRelevance(5);
		f1.setTotalComments(10);
		
		Optional<Feed> f2=Optional.of(f1);
		Mockito.when(feedRepo.findById(12)).thenReturn(f2);
		 Mockito.when(feedRepo.existsById(f1.getFeedId())).thenReturn(false);
		   assertFalse(feedRepo.existsById(f1.getFeedId()));
	}
	

	
}
