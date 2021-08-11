package com.cg.dca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.dca.entity.Response;
import com.cg.dca.exception.ResponseAlreadyExistsException;
import com.cg.dca.exception.UnknownDeveloperException;
import com.cg.dca.exception.UnknownFeedException;
import com.cg.dca.exception.UnknownResponseException;
import com.cg.dca.repository.IResponseRepository;

public class IResponseServiceImpl implements IResponseService {
	//using the methods of crud repository
	@Autowired
	IResponseRepository responserepo;

	@Override
	public Optional<Response> addResponse(Response resp)  {
		Optional<Response> response = responserepo.findById(resp.getRespId());
		if(response.isPresent()) {
			throw new ResponseAlreadyExistsException("Response with response id: " +resp.getRespId() + " already exists:RESPONSE CAN'T BE ADDED");
				}
		responserepo.save(resp);
		return response;
	}

	@Override
	public Optional<Response> editResponse(Response resp){
		Optional<Response> response = responserepo.findById(resp.getRespId());
		if(!(response.isPresent())) {
			throw new UnknownResponseException("Response with id: " + resp.getRespId() + " not present:NO SUCH RESPONSE TO EDIT");
		}
		responserepo.save(resp);
		return response;
	}

	@Override
	public Optional<Response> removeResponse(int respId)  {
		Optional<Response> response = responserepo.findById(respId);
		if(!response.isPresent()){
			throw new UnknownResponseException("Response with id: " + respId + " not present:NO SUCH RESPONSE TO DELETE");
		}
		responserepo.deleteById(respId);
		return response;
	}

	@Override
	public Optional<Response> likeResponse(int respId) {
		
		return null;
	}

	@Override
	public List<Response> getResponseByFeed(int feedId)  {
	
		return null;
		
	}

	@Override
	public List<Response> getResponseByDeveloper(int devId)  {
		
		return null;
	}

}
