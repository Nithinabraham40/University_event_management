package com.tutorial.university.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.university.model.Event;
import com.tutorial.university.services.EventServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/event")
public class EventController {

	
	@Autowired
	
	private EventServices eventServices;
	
	

	
	@PostMapping("/add")
	
	public String addAllEvents(@Valid @RequestBody List<Event>listOfEvents) {
		
		
		return eventServices.addAllEvents(listOfEvents);
		
	}
	
	@PutMapping("/update/eventname/{eventname}/id/{id}")
	
	public void updateEventNameByid(@PathVariable("eventname") String eventname,@PathVariable ("id") String id) {
		
		eventServices.updateEventNameById(eventname,id);
		
		
	}
	
	@DeleteMapping("/delete/id/{id}")
	
	public void deleteEventById(@PathVariable ("id") Long id) {
		
		eventServices.deleteEventById(id);
	}
	
	@GetMapping("/date/{date}")
	
	public List<Event>getAllEventAftertheseDate(@PathVariable ("date") String date){
		
		
		return eventServices.getAllEventAfterTheseDate(date);
	}
	@GetMapping("/all")
	
	public Iterable<Event>getAll(){
		
		return eventServices.getall();
	}
	
	
}
