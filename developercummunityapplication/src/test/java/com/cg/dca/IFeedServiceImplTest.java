package com.cg.dca;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.dca.entity.Feed;
import com.cg.dca.repository.IFeedRepository;
import com.cg.dca.service.IFeedService;

@SpringBootTest
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
}
