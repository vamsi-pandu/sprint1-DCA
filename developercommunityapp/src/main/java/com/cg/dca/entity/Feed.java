package com.cg.dca.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Feed")
public class Feed {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedId;
	private String query;
	private LocalDate feedDate;
	private LocalTime feedTime;
	private String topic;	// Programming/Java/Testing
	private int relevance;	// Likes on Feed increase relevance
	private Developer dev;
	private List<Response> responses;
	private int totalComments;
	public Feed() {
		super();
	}
	public Feed(int feedId, String query, LocalDate feedDate, LocalTime feedTime, String topic, int relevance,
			Developer dev, List<Response> responses, int totalComments) {
		super();
		this.feedId = feedId;
		this.query = query;
		this.feedDate = feedDate;
		this.feedTime = feedTime;
		this.topic = topic;
		this.relevance = relevance;
		this.dev = dev;
		this.responses = responses;
		this.totalComments = totalComments;
	}
	public int getFeedId() {
		return feedId;
	}
	public void setFeedId(int feedId) {
		this.feedId = feedId;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public LocalDate getFeedDate() {
		return feedDate;
	}
	public void setFeedDate(LocalDate feedDate) {
		this.feedDate = feedDate;
	}
	public LocalTime getFeedTime() {
		return feedTime;
	}
	public void setFeedTime(LocalTime feedTime) {
		this.feedTime = feedTime;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public int getRelevance() {
		return relevance;
	}
	public void setRelevance(int relevance) {
		this.relevance = relevance;
	}
	public Developer getDev() {
		return dev;
	}
	public void setDev(Developer dev) {
		this.dev = dev;
	}
	public List<Response> getResponses() {
		return responses;
	}
	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}
	public int getTotalComments() {
		return totalComments;
	}
	public void setTotalComments(int totalComments) {
		this.totalComments = totalComments;
	}
	
}
