package com.cg.dca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.dca.entity.Feed;
import com.cg.dca.entity.Topic;

@Repository
public interface IFeedRepository extends JpaRepository<Feed, Integer>{

/*  Feed saveFeed(Feed feed);
	
	Feed updateFeed(Feed feed);
	
	Feed fetchFeed(int feedId) throws UnknownFeedException;
	
	Optional<Feed> deleteFeed(Optional<Feed> feed) throws UnknownFeedException;    */
	
	List<Feed> findAllByDeveloper_DevId(int devId);
	
	@Query("SELECT b FROM Feed b WHERE b.query like %:keyword%")
	List<Feed> findByKeyword(@Param("keyword") String keyword);
	
	
	List<Feed> findAllByTopic(Topic topic);

	
}
