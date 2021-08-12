package com.cg.dca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dca.entity.Response;
import com.cg.dca.exception.ResponseAlreadyExistsException;
import com.cg.dca.exception.UnknownResponseException;
import com.cg.dca.repository.IResponseRepository;

@Service
public class IResponseServiceImpl implements IResponseService {
	//using the methods of crud repository
	@Autowired
	IResponseRepository responseRepo;
	
	

	public IResponseServiceImpl(IResponseRepository responseRepo) {
		super();
		this.responseRepo = responseRepo;
	}

	@Override
	public Response addResponse(Response resp)  {
		if(responseRepo.existsById(resp.getRespId())) {
			throw new ResponseAlreadyExistsException("Response with response id: " +resp.getRespId() + " already exists:RESPONSE CAN'T BE ADDED");
		}
		return responseRepo.save(resp);
		
	}

	@Override
	public Response editResponse(Response resp){
		if(responseRepo.existsById(resp.getRespId())) {
			return responseRepo.save(resp);
		}
		else {
			throw new UnknownResponseException("Response with id: " + resp.getRespId() + " not present:NO SUCH RESPONSE TO EDIT");
		}
	}

	@Override
	public Optional<Response> removeResponse(int respId)  {
		Optional<Response> response = responseRepo.findById(respId);
		if(!response.isPresent()){
			throw new UnknownResponseException("Response with id: " + respId + " not present:NO SUCH RESPONSE TO DELETE");
		}
		responseRepo.deleteById(respId);
		return response;
	}



	@Override
	public List<Response> getResponseByFeed(int feedId)  {
		List<Response> ListOfResponsesByFeed = responseRepo.findAllResponseByFeed_FeedId(feedId);
		if(ListOfResponsesByFeed.isEmpty()) {
			throw new UnknownResponseException("No Responses found for the feed id: " + feedId);
		}
		return ListOfResponsesByFeed ;
		
	}

	@Override
	public List<Response> getResponseByDeveloper(int devId)  {
		List<Response> ListOfResponseByDeveloper = responseRepo.findAllResponseByDeveloper_DevId(devId);
		if(ListOfResponseByDeveloper.isEmpty()) {
			throw new UnknownResponseException("No Responses found for the feed id: " + devId);
		}
		return ListOfResponseByDeveloper ;

}
	}
