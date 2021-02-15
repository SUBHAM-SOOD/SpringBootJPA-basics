package com.sood1.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sood1.model.Alien;
/*
 * 
 Thanks to JPA we can directly create interface and extend CrudRepo and do CRUD operations
 * /
 */
public interface AlienRepo extends JpaRepository<Alien, Integer>{
	
		
	List<Alien> findByTech(String tech);
	
	List<Alien> findByAidGreaterThan(int aid);
	
	List<Alien> findByAidLessThan(int aid);
	
	@Query("from Alien where Tech = ?1 order by Aname DESC") // This is known as JPQL
	List<Alien> findByTechSorted(String Tech);
	
}
