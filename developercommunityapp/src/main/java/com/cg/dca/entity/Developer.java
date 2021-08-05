package com.cg.dca.entity;

import java.time.LocalDate;
import java.util.List;

public class Developer {
	private int devId;
	private String name;
	private String email;
	private String skillLevel;	// Beginner/Intermediate/Expert
	private LocalDate memberSince;
	private List<Feed> feeds;
	private User user;
	private int totalFeeds;	
	private int reputation;		// Likes on Feed/Response by developer increase reputation
	private boolean isVerified;
	private boolean isBlocked;	// Can be blocked by admin on the ground of unethical feed/response
}
