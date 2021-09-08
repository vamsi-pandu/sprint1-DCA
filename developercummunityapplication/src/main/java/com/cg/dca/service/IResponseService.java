package com.cg.dca.service;

import java.util.List;
import java.util.Optional;

import com.cg.dca.entity.Feed;
import com.cg.dca.entity.Response;

public interface IResponseService {
	
	Response addResponse(Response resp);
	
	Response editResponse(Response resp);
	
	Optional<Response> getResponse(int respId);     
	
	Optional<Response> removeResponse(int respId) ;
	
	List<Response> getResponseByFeed(int feedId) ;
	
	List<Response> getResponseByDeveloper(int devId);
}
