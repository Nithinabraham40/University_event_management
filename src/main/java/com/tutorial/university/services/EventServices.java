package com.tutorial.university.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.university.model.Event;
import com.tutorial.university.repository.EventRepository;

import jakarta.validation.Valid;

@Service
public class EventServices {

	
	@Autowired
	private EventRepository eventRepository;

	public String addAllEvents(@Valid List<Event> listOfEvents) {
	
		
		Iterable<Event>allEvent=eventRepository.saveAll(listOfEvents);
		
		if(allEvent!=null) {
			return "Sucessfully Added";
		}
		return "not  added";
	}

	public void updateEventNameById(String eventname,String id) {
		
		eventRepository.updateEventNameWhereIdIs(eventname, id);
		
		
	}

	public void deleteEventById(Long id) {
	
		
		eventRepository.deleteById(id);
		
	}

	public List<Event> getAllEventAfterTheseDate(String date) {
	
		return eventRepository.getAllEventAfterDate(date);
	}

	public Iterable<Event> getall() {
		
		return eventRepository.findAll();
	}
	
	
}
