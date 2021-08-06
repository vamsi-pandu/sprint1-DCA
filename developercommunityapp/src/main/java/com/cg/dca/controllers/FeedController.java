package com.cg.dca.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dca.entity.Feed;
import com.cg.dca.service.IFeedService;

@RestController
@RequestMapping("feeds")
public class FeedController {
	
	@Autowired
	IFeedService service;

	@PostMapping
	public String saveFeed(  @Valid @RequestBody Feed f) {
		service.addFeed(f);
		return "Feed Data successfully saved";

	}

}
