package com.cg.dca.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Developer")
//Serializable is useful to recreate objects into its original state
public class Developer implements Serializable {

//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private static final long serialVersionUID = 1L;
	@Id
	@Column(name="dev_id")
	private	int devId;
	
	@NotEmpty(message = "Name Should not be empty")
	@Size(min=3, max=25)
	@Column(name="name")
	private String name;
	
	@NotEmpty(message = "Email must be entered")
	@Email(message = "Email is Not Valid")
	@Column(name="email")
	private String email;
	
	
	@Column(name="skill_level")
	private SkillLevel skillLevel;
	
	
	@Column(name="member_since")
	private LocalDate memberSince;
	
	
	@Column(name="total_feeds")
	private int  totalFeeds;
	
	


	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_user_id")
	@JsonBackReference
	private User user;

	
	@OneToMany(mappedBy="developer",cascade=CascadeType.ALL)
	@JsonIgnore
	private  List<Feed> feedList;

	@Column(name="is_verified")
	private Boolean isVerified;
	
	@Column(name="is_blocked")
	private Boolean isBlocked;
	
	public Developer() {
		super();
	}

	public int getDevId() {
		return devId;
	}
	public void setDevId(int devId) {
		this.devId = devId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public SkillLevel getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(SkillLevel skillLevel) {
		this.skillLevel = skillLevel;
	}

	public LocalDate getMemberSince() {
		return memberSince;
	}
	public void setMemberSince(LocalDate memberSince) {
		this.memberSince = memberSince;
	}
	public int getTotalFeeds() {
		return totalFeeds;
	}
	public void setTotalFeeds(int totalFeeds) {
		this.totalFeeds = totalFeeds;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public List<Feed> getFeedList() {
		return feedList;
	}
	public void setFeedList(List<Feed> feedList) {
		this.feedList = feedList;
	}
	public Boolean getIsVerified() {
		return isVerified;
	}
	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}
	public Boolean getIsBlocked() {
		return isBlocked;
	}
	public void setIsBlocked(Boolean isBlocked) {
		this.isBlocked = isBlocked;
	}
	

}
