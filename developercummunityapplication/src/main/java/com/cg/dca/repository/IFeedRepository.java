package com.cg.dca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.dca.entity.Feed;
import com.cg.dca.entity.Topic;

@Repository                                //  used to declare class as a repository object, auto-detected by spring framework
public interface IFeedRepository extends JpaRepository<Feed, Integer>{  
	
	List<Feed> findAllByDeveloper_DevId(int devId);
	
	@Query("SELECT feed FROM Feed feed WHERE feed.query like %:keyword%")    //  custom query
	List<Feed> findByKeyword(@Param("keyword") String keyword);    //  Annotation to bind method parameters to a query via a named parameter.
	
	
	List<Feed> findAllByTopic(Topic topic);         //  method to list feed by topic

	
}
