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

@Entity
@Table(name="Developer")
public class Developer implements Serializable {

	@Column(name="dev_id")
	@Id
	private	int devId;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="skill_level")
	private String skillLevel;
	@Column(name="member_since")
	private LocalDate memberSince;
	@Column(name="total_feeds")
	private int  totalFeeds;
	@Column(name="reputation")
	private int  reputations;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_user_id")
	private User user;

	
	@OneToMany(mappedBy="developer",cascade=CascadeType.ALL)
	private  List<Feed> feedList;

	@Column(name="is_verified")
	private Boolean isVerified;
	@Column(name="is_blocked")
	private Boolean isBlocked;
	
	public Developer() {
		super();
	}
	
	public Developer(int devId, String name, String email, String skillLevel, LocalDate memberSince, int totalFeeds,
			int reputations, User user, List<Feed> feedList, Boolean isVerified, Boolean isBlocked) {
		super();
		this.devId = devId;
		this.name = name;
		this.email = email;
		this.skillLevel = skillLevel;
		this.memberSince = memberSince;
		this.totalFeeds = totalFeeds;
		this.reputations = reputations;
		this.user = user;
		this.feedList = feedList;
		this.isVerified = isVerified;
		this.isBlocked = isBlocked;
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
	public String getSkillLevel() {
		return skillLevel;
	}
	public void setSkillLevel(String skillLevel) {
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
	public int getReputations() {
		return reputations;
	}
	public void setReputations(int reputations) {
		this.reputations = reputations;
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
	@Override
	public String toString() {
		return "Developer [devId=" + devId + ", name=" + name + ", email=" + email + ", skillLevel=" + skillLevel
				+ ", memberSince=" + memberSince + ", totalFeeds=" + totalFeeds + ", reputations=" + reputations
				+ ", user=" + user + ", feedList=" + feedList + ", isVerified=" + isVerified + ", isBlocked="
				+ isBlocked + "]";
	}

}
