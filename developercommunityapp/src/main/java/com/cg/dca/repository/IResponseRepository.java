package com.cg.dca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dca.entity.Response;
import com.cg.dca.exception.UnknownDeveloperException;
import com.cg.dca.exception.UnknownFeedException;
import com.cg.dca.exception.UnknownResponseException;

@Repository
public interface IResponseRepository extends JpaRepository<Response, Integer> {
	
	/*Response saveResponse(Response resp);
	
	Response updateResponse(Response resp);
	
	Response removeResponse(int respId) throws UnknownResponseException;
	
	Response likeResponse(int respId);*/
	
	List<Response> fetchResponseByFeed(int feedId) throws UnknownFeedException;
	
	List<Response> fetchResponseByDeveloper(int devId) throws UnknownDeveloperException;
}
