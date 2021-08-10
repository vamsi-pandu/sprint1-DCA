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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="Developer")
public class Developer implements Serializable {

	
	//private static final long serialVersionUID = 1L;
	@Column(name="dev_id")
	@Id
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


	public Developer(int devId, @NotEmpty(message = "Name Should not be empty") @Size(min = 3, max = 25) String name,
			@NotEmpty(message = "Email must be entered") @Email(message = "Email is Not Valid") String email,
			SkillLevel skillLevel, LocalDate memberSince, int totalFeeds, int reputations, User user,
			List<Feed> feedList, Boolean isVerified, Boolean isBlocked) {
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
