package com.cg.dca.service;

import java.util.List;
import java.util.Optional;

import com.cg.dca.entity.Response;
import com.cg.dca.exception.ResponseAlreadyExistsException;
import com.cg.dca.exception.UnknownDeveloperException;
import com.cg.dca.exception.UnknownFeedException;
import com.cg.dca.exception.UnknownResponseException;

public interface IResponseService {
	
	Optional<Response> addResponse(Response resp);
	
	Optional<Response> editResponse(Response resp);
	
	Optional<Response> removeResponse(int respId) ;
	
	Optional<Response> likeResponse(int respId);
	
	List<Response> getResponseByFeed(int feedId) ;
	
	List<Response> getResponseByDeveloper(int devId);
}
