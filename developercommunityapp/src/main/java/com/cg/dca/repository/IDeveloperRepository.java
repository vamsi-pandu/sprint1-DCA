package com.cg.dca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dca.entity.Developer;
import com.cg.dca.exception.UnknownDeveloperException;
@Repository
public interface IDeveloperRepository extends JpaRepository<Developer,Integer> {

	/*Developer saveDeveloper(Developer dev);
	
	Developer updateDeveloper(Developer dev);
	
	*/
	Developer statusUpdate(Developer dev);

	
<<<<<<< Updated upstream
	Optional<Developer> findById(int devId);
=======
	Developer findById(int devId);
>>>>>>> Stashed changes
	
	
	List<Developer> findAll();
	
}
