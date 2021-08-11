package com.dca;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.cg.dca.entity.Developer;
import com.cg.dca.entity.Response;
import com.cg.dca.entity.SkillLevel;
import com.cg.dca.entity.User;
import com.cg.dca.exception.DeveloperAlreadyExistsException;
import com.cg.dca.exception.ResponseAlreadyExistsException;
import com.cg.dca.exception.UnknownDeveloperException;
import com.cg.dca.repository.IDeveloperRepository;
import com.cg.dca.service.IDeveloperService;
import com.cg.dca.service.IDeveloperServiceImpl;

class IDeveloperServiceImplTest {

	IDeveloperRepository developerRepo = Mockito.mock(IDeveloperRepository.class);
	IDeveloperService developerService = new IDeveloperServiceImpl(developerRepo);
	
	
	
	@Test
	void listOfAllDeveloper() {
		int myValue =  developerService.getAllDevelopers().size();
		int actualValue = developerRepo.findAll().size();
		assertEquals(myValue,actualValue);
	}
	
	
	
	
	@Test
	public void testGetDeveloper() {

		when(developerRepo.findById(999)).thenThrow(EntityNotFoundException.class);
		
		try {
			Optional<Developer> d= developerRepo.findById(999);
			fail("Not throwing exception for developer 999");
		}
		catch(EntityNotFoundException ex) {
			assertTrue(true);
		}
		
	}
	
	@Test
	public void addDeveloperTest()
	{
		Developer developer = new Developer();
		developer.setDevId(100);
		developer.setEmail("azmathshyr@gmail.com");
		developer.setIsBlocked(false);
		developer.setName("Azmath");
		when(developerRepo.existsById(100)).thenReturn(true);
		assertEquals("Azmath", developer.getName());
		
	}
	
}
