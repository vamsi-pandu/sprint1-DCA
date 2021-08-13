package com.cg.dca.entity;

import java.time.LocalDateTime;
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
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Feed")
public class Feed {
	
	@Id                                                  //  Specifies the primary key of an entity      
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Provides for the specification of generation strategies for the values of primary keys. 
	@Column(name="feed_id" ,nullable = false)          // Column specifies the mapped column for a persistent property or field.
	private int feedId;   
	
	@NotBlank(message = "Query is mandatory")        //  The annotated element must not be null and must contain at least one non-whitespace character.
	private String query;
	

	@CreationTimestamp                            //  The property value will be set to the current VM date whenever entity is saved for first time
	@Column(name = "feed_time",updatable=false)
	private LocalDateTime feedTime;
	
	@UpdateTimestamp                           //  The property value will be set to the current VM date whenever the entity is updated. 
	@Column(name="feed_updation_time")
    private LocalDateTime updateDateTime;
	
	
	private Topic topic;                     //Enum :  Programming/Java/Testing
	
	
	@ManyToOne                               //  one developer is mapped with one or many feeds
	@JoinColumn(name ="fk_developer_id")     //  this column is joined in the feed entity table
	@JsonBackReference                       // is used to mark child objects.
	private Developer developer;
	
	@OneToMany(mappedBy="feed",cascade=CascadeType.ALL)  //  one feed is mapped to many responses
	@JsonIgnore                                         //is used at field level to mark a property or list of properties to be ignored.
	private List<Response> responses;
	
	private int totalComments;
	
	
	public Feed() {                          //  default constructor
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
	
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
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
	
	
	
}
