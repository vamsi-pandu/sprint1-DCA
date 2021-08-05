package com.cg.dca.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="response")

public class Response {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int respId;
	private String answer;
	private LocalDate respDate;
	private LocalTime respTime;
	private int accuracy;	// Likes on Response increase accuracy
	private Developer dev;
	private Feed feed;
	public Response(int respId, String answer, LocalDate respDate, LocalTime respTime, int accuracy, Developer dev,
			Feed feed) {
		super();
		this.respId = respId;
		this.answer = answer;
		this.respDate = respDate;
		this.respTime = respTime;
		this.accuracy = accuracy;
		this.dev = dev;
		this.feed = feed;
	}
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
	public LocalDate getRespDate() {
		return respDate;
	}
	public void setRespDate(LocalDate respDate) {
		this.respDate = respDate;
	}
	public LocalTime getRespTime() {
		return respTime;
	}
	public void setRespTime(LocalTime respTime) {
		this.respTime = respTime;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public Developer getDev() {
		return dev;
	}
	public void setDev(Developer dev) {
		this.dev = dev;
	}
	public Feed getFeed() {
		return feed;
	}
	public void setFeed(Feed feed) {
		this.feed = feed;
	}


}
