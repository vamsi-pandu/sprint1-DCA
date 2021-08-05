package com.cg.dca.service;

import java.util.List;

import com.cg.dca.entity.Response;
import com.cg.dca.exception.UnknownDeveloperException;
import com.cg.dca.exception.UnknownFeedException;
import com.cg.dca.exception.UnknownResponseException;

public interface IResponseService {
	
	Response addResponse(Response resp);
	
	Response editResponse(Response resp);
	
	Response removeResponse(int respId) throws UnknownResponseException;
	
	Response likeResponse(int respId);
	
	List<Response> getResponseByFeed(int feedId) throws UnknownFeedException;
	
	List<Response> getResponseByDeveloper(int devId) throws UnknownDeveloperException;
}
