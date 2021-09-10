package com.cg.dca.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dca.entity.Developer;
import com.cg.dca.entity.Feed;
import com.cg.dca.entity.Topic;
import com.cg.dca.service.IFeedService;

//@RestController-@Controller + @ResponseBody, BY default it returns JSON.
//It eliminates need of annotating every handling method with @ResponseBody
//@RequestMapping annotation maps HTTP requests to handler methods of  REST controllers.

@RestController    
@RequestMapping("feed") 
@CrossOrigin(origins = "http://localhost:4200")
public class FeedController {
	
	@Autowired
	IFeedService service; 
	
	Developer developer = null;

	 //RequestBody-spring will bind incoming HTTP request body(for the url method in @RequestMapping for that method)to that parameter
	 //ResponseEntity<> requests whole HTTP response:(status code,headers,body) 
	
	    //this method is to create new feed and save
	    //@PostMapping annotated methods handle the HTTP POST requests matched with given URI expression.
	   @GetMapping
	    public ResponseEntity<?> getAllFeeds(HttpServletRequest request) {
	 	List<Feed> list = (List<Feed>) service.getAllFeeds();

		return new ResponseEntity<Object>(list, HttpStatus.OK);

	    }
	    
	    @PostMapping("/save/{devId}")
		public ResponseEntity<?> saveFeed(@Valid  @RequestBody Feed feed, @PathVariable("devId") int devId){    
			System.out.println(devId);
			System.out.println(feed);
	    	service.addFeed(feed,devId);
			return new ResponseEntity<String>("Feed Added Successfully",HttpStatus.OK); 
		}


        //this method is to get feed by providing feedId
		@GetMapping("{feedId}")
		public ResponseEntity<?> getFeed(@PathVariable("feedId") int feedId){
			Optional<Feed> feed = service.getFeed(feedId);
			return new ResponseEntity<Feed>(feed.get(),HttpStatus.OK);
		}

		

        //this method is to update feed details
		//@PutMapping annotation for mapping HTTP PUT requests onto specific handler methods.
		@PutMapping("update/{feedId}")
		public ResponseEntity<?> updateFeed(@RequestBody Feed feed){
			service.editFeed(feed);
			return new ResponseEntity<String>("Feed Updated Succesfully",HttpStatus.OK);

		}

		//this method is to delete the feed by providing feedId
		//@DeleteMapping annotation for mapping HTTP DELETE requests onto specific handler methods.
		@DeleteMapping("/delete/{feedId}")
		public ResponseEntity<?> deleteFeed(@PathVariable("feedId") int feedId){
			service.removeFeed(feedId);
			return new ResponseEntity<String>("Feed Deleted Succesfully",HttpStatus.OK);

		}

		//this method is to get list of feeds by developer by providing developer id.
		@GetMapping("/getFeedBydeveloper/{devId}")
		public ResponseEntity<?> getFeedByDeveloper(@PathVariable("devId") int devId){
			List<Feed> listOfFeeds = (List<Feed>) service.getFeedsByDeveloper(devId);

			return new ResponseEntity<Object>(listOfFeeds,HttpStatus.OK);
		}


		//this method is to get list of feeds by topic.
		//@GetMapping annotated methods handle the HTTP GET requests matched with given URI expression
		@GetMapping("/getFeedBytopic/{topic}")
		public ResponseEntity<?> getFeedByTopic(@PathVariable("topic") Topic topic){
			List<Feed> listOfTopics = (List<Feed>) service.getFeedsByTopic(topic);

			return new ResponseEntity<Object>(listOfTopics,HttpStatus.OK);
		}


		//this method is to get list of feeds by keyword.
		@GetMapping("/getFeedBykeyword/{keyword}")
		public ResponseEntity<?> getFeedByKeyword(@PathVariable("keyword") String keyword){
			List<Feed> listOfKeyword = (List<Feed>) service.getFeedsByKeyword(keyword);

			return new ResponseEntity<Object>(listOfKeyword,HttpStatus.OK);
		}


}


