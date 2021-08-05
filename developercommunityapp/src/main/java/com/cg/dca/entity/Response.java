package com.cg.dca.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Response {
	private int respId;
	private String answer;
	private LocalDate respDate;
	private LocalTime respTime;
	private int accuracy;	// Likes on Response increase accuracy
	private Developer dev;
	private Feed feed;
}
