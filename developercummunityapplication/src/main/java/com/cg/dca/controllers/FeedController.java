package com.cg.dca.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dca.entity.Feed;
import com.cg.dca.entity.Topic;
import com.cg.dca.service.IFeedService;

@RestController
@RequestMapping("feed")
public class FeedController {
	
	@Autowired
	IFeedService service;

	
	
		@PostMapping("save")
		public ResponseEntity<?> saveFeed(@Valid  @RequestBody Feed feed){
			service.addFeed(feed);
			return new ResponseEntity<String>("Feed Added Successfully",HttpStatus.OK);
		}



		@GetMapping("{feedId}")
		public ResponseEntity<?> getFeed(@PathVariable("feedId") int feedId){
			Optional<Feed> feed = service.getFeed(feedId);
			return new ResponseEntity<Feed>(feed.get(),HttpStatus.OK);
		}



		@GetMapping("/developer/{devId}")
		public ResponseEntity<?> getFeedByDeveloper(@PathVariable("devId") int devId){
			List<Feed> listOfFeeds = (List<Feed>) service.getFeedsByDeveloper(devId);

			return new ResponseEntity<Object>(listOfFeeds,HttpStatus.OK);
		}


		@GetMapping("/topic/{topic}")
		public ResponseEntity<?> getFeedByTopic(@PathVariable("topic") Topic topic){
			List<Feed> listOfTopics = (List<Feed>) service.getFeedsByTopic(topic);

			return new ResponseEntity<Object>(listOfTopics,HttpStatus.OK);
		}


		
		@GetMapping("/keyword/{keyword}")
		public ResponseEntity<?> getFeedByKeyword(@PathVariable("keyword") String keyword){
			List<Feed> listOfKeyword = (List<Feed>) service.getFeedsByKeyword(keyword);

			return new ResponseEntity<Object>(listOfKeyword,HttpStatus.OK);
		}



		@DeleteMapping("{feedId}")
		public ResponseEntity<?> deleteFeed(@PathVariable("feedId") int feedId){
			service.removeFeed(feedId);
			return new ResponseEntity<String>("Feed Deleted Succesfully",HttpStatus.OK);

		}


		@PutMapping("update")
		public ResponseEntity<?> updateFeed(@RequestBody Feed feed){
			service.editFeed(feed);
			return new ResponseEntity<String>("Feed Updated Succesfully",HttpStatus.OK);

		}


}


