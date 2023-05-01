package com.tutorial.university.model;





import com.tutorial.university.custumvalidation.Capitalized;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_student")
public class Student {


	
	@Id
	@SequenceGenerator(name = "student_sequence",sequenceName = "student_sequence",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private  Long studentId;
	
	@NotNull
	@Size(min = 2,max = 20)
	@Capitalized 
	private String firstName;
	@NotNull
	@Size(min = 2,max = 20)
	private String lastName;
	@Min(value = 18)
	@Max(value = 25)
	private int studentAge;
	@Enumerated(EnumType.STRING)
	private Department departmentType;
	
	
}
