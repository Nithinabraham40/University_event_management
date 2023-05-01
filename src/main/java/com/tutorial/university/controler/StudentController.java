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

import com.tutorial.university.model.Student;
import com.tutorial.university.repository.StudentRepository;
import com.tutorial.university.services.StudentServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {

	
	
	@Autowired
	private StudentServices studentServices;
	

	
	@PostMapping("/add")
	public String addAllStudent(@Valid @RequestBody List<Student>studentList) {
		
		
		return studentServices.addAllStudents(studentList);
		
	}
	
	
	
	@PutMapping("/update/{department}/id/{id}")
	
	public void updateStudentDepById(@PathVariable("department") String department,@PathVariable("id") String id) {
		
		
		 studentServices.updateStudentDeptById( department,id);
		
	}
	
	
	
	
	@DeleteMapping("/delete/id/{id}")
	
  public void deleteStudentById(@PathVariable("id") String id) {
		
		studentServices.deleteById(id);
	}
	
	
	
	@GetMapping("all")
	public Iterable<Student>getAllStudents(){
		return studentServices.getAllStudents();
	}
	
	
	
	@GetMapping("id/{id}")
	
	public Student getStudentById(@PathVariable ("id") Long id) {
		
		return studentServices.getStudentById(id);
	}
	
}
