package com.cg.dca.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "feed")
public class Feed {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedId;
	private String query;
	
	@Column(name = "feed_date")
	private LocalDate feedDate;
	
	@Column(name = "feed_time")
	private LocalTime feedTime;
	
	private String topic;	// Programming/Java/Testing
	private int relevance;	// Likes on Feed increase relevance
	
	@ManyToOne
	@JoinColumn(name ="fk_developer_id")
	@JsonBackReference
	private Developer developer;
	
	@OneToMany(mappedBy="feed",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Response> responses;
	
	private int totalComments;
	
	public Feed() {
		super();
	}
	public Feed(int feedId, String query, LocalDate feedDate, LocalTime feedTime, String topic, int relevance,
			Developer developer, List<Response> responses, int totalComments) {
		super();
		this.feedId = feedId;
		this.query = query;
		this.feedDate = feedDate;
		this.feedTime = feedTime;
		this.topic = topic;
		this.relevance = relevance;
		this.developer = developer;
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
	public Developer getDeveloper() {
		return developer;
	}
	public void setDev(Developer developer) {
		this.developer = developer;
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
