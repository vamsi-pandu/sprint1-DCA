
package com.dca;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.dca.entity.Developer;
import com.cg.dca.entity.Feed;
import com.cg.dca.entity.Response;
import com.cg.dca.exception.ResponseAlreadyExistsException;
import com.cg.dca.repository.IResponseRepository;
import com.cg.dca.service.IResponseService;
import com.cg.dca.service.IResponseServiceImpl;


class IResponseServiceImplTest {

	IResponseRepository responseRepo = Mockito.mock(IResponseRepository.class);

	IResponseServiceImpl service = new IResponseServiceImpl(responseRepo);


	
	@Test
	void testAddResponse() {
		Response r = new Response();
		r.setRespId(105);
		r.setResponseTime(LocalDateTime.now());
		r.setUpdatedResponseDateTime(LocalDateTime.now());
		r.setAnswer("Responses are listed successfully");
		when(responseRepo.existsById(105)).thenReturn(true);
		try {
			Response savedresponse = service.addResponse(r);
			fail("expected");

		} catch (ResponseAlreadyExistsException e) {
			assertTrue(true);

		}

		// assertEquals(savedresponse, service.addResponse(r) );
	}
	@Test
	public void getResponseByDeveloperTest() {
		Response response = new Response();
		response.setRespId(202);
		response.setAnswer("json is client side language");
		
		Developer developer = new Developer();
		developer.setDevId(101);
		response.setDeveloper(developer);
		
		Feed feed = new Feed();
		feed.setFeedId(201);
		response.setFeed(feed);
		
		response.setUpdatedResponseDateTime(LocalDateTime.now());
		response.setResponseTime(LocalDateTime.now());
		
		List<Response> responseList = new ArrayList<Response>();
		responseList.add(response);
		when(responseRepo.findAllResponseByDeveloper_DevId(101)).thenReturn(responseList);
		assertThat(service.getResponseByDeveloper(101)).isEqualTo(responseList);
	}
	
	@Test
	public void getResponseByFeedTest() {
		Response response = new Response();
		response.setRespId(202);
		response.setAnswer("json is client side language");
		
		Developer developer = new Developer();
		developer.setDevId(101);
		response.setDeveloper(developer);
		
		Feed feed = new Feed();
		feed.setFeedId(201);
		response.setFeed(feed);
		
		response.setUpdatedResponseDateTime(LocalDateTime.now());
		response.setResponseTime(LocalDateTime.now());
		
		List<Response> responseList = new ArrayList<Response>();
		responseList.add(response);
		when(responseRepo.findAllResponseByFeed_FeedId(201)).thenReturn(responseList);
		assertThat(service.getResponseByFeed(201)).isEqualTo(responseList);
	
		
	}
}
