package com.cg.dca;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.dca.entity.Response;
import com.cg.dca.repository.IResponseRepository;
import com.cg.dca.service.IResponseService;

@SpringBootTest
class IResponseServiceImplTest {
	
	@Autowired
	IResponseService service;
	
	@Autowired
	IResponseRepository responseRepo;

	@Test
	void testAddResponse() {
		Response r= new Response();
		r.setRespId(101);
		r.setRespTime(LocalTime.now());
		r.setRespDate(LocalDate.now());
		r.setAnswer("Responses are listed successfully");
		
		Response savedresponse = service.addResponse(r);
		//assertThat(savedresponse).usingRecursiveComparison().ignoringFields("respId").isEqualTo(r);
		assertEquals(savedresponse, service.addResponse(r) );
	}
}
