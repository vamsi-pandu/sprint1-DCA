package com.cg.dca.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Feed {
	private int feedId;
	private String query;
	private LocalDate feedDate;
	private LocalTime feedTime;
	private String topic;	// Programming/Java/Testing
	private int relevance;	// Likes on Feed increase relevance
	private Developer dev;
	private List<Response> responses;
	private int totalComments;
}
