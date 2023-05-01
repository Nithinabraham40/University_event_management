package com.tutorial.university.model;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_event")
public class Event {

	
	
////	eventId
//	eventName
//	locationOfEvent
//	date
//	startTime
//	endTime
//}
	
	@Id
	@SequenceGenerator(name = "event_sequence",sequenceName = "event_sequence",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long eventId;
	
	@NotNull
	private String eventName;
	@NotBlank
	private String locationOfevent;
	@FutureOrPresent
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate eventDate;
	@NotNull
	@DateTimeFormat(pattern = "HH:mm:ss")
	private LocalTime startTime;
	@NotNull
	@DateTimeFormat(pattern = "HH:mm:ss")
	private LocalTime endTime;

	
}