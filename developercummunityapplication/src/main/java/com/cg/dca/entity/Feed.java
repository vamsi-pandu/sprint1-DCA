package com.cg.dca.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Feed")
public class Feed {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="feed_id")
	private int feedId;
	
	private String query;
	

	@Column(name = "feed_time")
	@CreationTimestamp
	private LocalDateTime feedTime;
	
	@UpdateTimestamp
	@Column(name="feed_updation_time")
    private LocalDateTime updateDateTime;
	
	private String topic;	// Programming/Java/Testing
	private int relevance;	// Likes on Feed increase relevance
	
	@ManyToOne
	@JoinColumn(name ="fk_developer_id")
	@JsonBackReference    // is used to mark child objects.
	private Developer developer;
	
	@OneToMany(mappedBy="feed",cascade=CascadeType.ALL)
	@JsonIgnore     //is used at field level to mark a property or list of properties to be ignored.
	private List<Response> responses;
	
	private int totalComments;
	
	
	public Feed() {
		super();
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
	
	public LocalDateTime getFeedTime() {
		return feedTime;
	}
	public void setFeedTime(LocalDateTime feedTime) {
		this.feedTime = feedTime;
	}
	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}
	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}
	public Developer getDeveloper() {
		return developer;
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
	@Override
	public String toString() {
		return "Feed [feedId=" + feedId + ", query=" + query + ", feedTime=" + feedTime + ", updateDateTime="
				+ updateDateTime + ", topic=" + topic + ", relevance=" + relevance + ", developer=" + developer
				+ ", responses=" + responses + ", totalComments=" + totalComments + "]";
	}
	
	
}
