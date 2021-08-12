package com.cg.dca.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="response")

public class Response {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="response_id")
	private int respId;
	
	@Column(name = "answer")
	private String answer;
	
	@Column(name = "response_time")
	@CreationTimestamp
	private LocalDateTime responseTime;
	
	@UpdateTimestamp
	@Column(name="response_updation_time")
    private LocalDateTime updatedResponseDateTime;
	
	@OneToOne
	@JoinColumn(name ="fk_dev_id")
	@JsonBackReference
	private Developer developer;
	
	@ManyToOne
	@JoinColumn(name ="fk_feed_id")
	@JsonIgnore
	private Feed feed;
	
	
	public Response() {
		super();
	} 
	public int getRespId() {
		return respId;
	}
	public void setRespId(int respId) {
		this.respId = respId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public LocalDateTime getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(LocalDateTime responseTime) {
		this.responseTime = responseTime;
	}
	public LocalDateTime getUpdatedResponseDateTime() {
		return updatedResponseDateTime;
	}
	public void setUpdatedResponseDateTime(LocalDateTime updatedResponseDateTime) {
		this.updatedResponseDateTime = updatedResponseDateTime;
	}
	
	public Developer getDeveloper() {
		return developer;
	}
	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}
	public Feed getFeed() {
		return feed;
	}
	public void setFeed(Feed feed) {
		this.feed = feed;
	}

}
