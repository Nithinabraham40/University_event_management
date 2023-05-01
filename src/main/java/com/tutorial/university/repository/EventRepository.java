package com.tutorial.university.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tutorial.university.model.Event;

import jakarta.transaction.Transactional;


public interface EventRepository extends CrudRepository<Event, Long>{
	
	
	@Modifying
	@Transactional
	@Query(
			value = "update tbl_event set event_name=:eventname where event_id=:eventid ",
			
			nativeQuery = true
			
			)
	
	void updateEventNameWhereIdIs(String eventname,String eventid);
	
	
	@Modifying
	@Transactional
	@Query(
			value="select * from tbl_event where event_date>:eventdate",
			
			nativeQuery = true)
			
	
	List<Event>getAllEventAfterDate(String eventdate);
	
	
	

}
