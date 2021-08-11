package com.cg.dca;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.dca.entity.Response;
import com.cg.dca.exception.ResponseAlreadyExistsException;
import com.cg.dca.repository.IResponseRepository;
import com.cg.dca.service.IResponseService;
import com.cg.dca.service.IResponseServiceImpl;

@SpringBootTest
class IResponseServiceImplTest {
	
	IResponseRepository responseRepo = Mockito.mock(IResponseRepository.class);

	
	IResponseServiceImpl service= new IResponseServiceImpl(responseRepo);
	
	
	
	@Test
	void testAddResponse() {
		Response r= new Response();
		r.setRespId(101);
		r.setResponseTime(LocalDateTime.now());
		r.setAnswer("Responses are listed successfully");
		when(responseRepo.existsById(101)).thenReturn(true);
		try{
			Response savedresponse = service.addResponse(r);
			fail("expected");
			
			}
		catch(ResponseAlreadyExistsException e){
			assertTrue(true);
			
		}
		
		//assertEquals(savedresponse, service.addResponse(r) );
	}
}
