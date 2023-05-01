package com.tutorial.university.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.university.model.Student;
import com.tutorial.university.repository.StudentRepository;

@Service
public class StudentServices {

	
	@Autowired
	private StudentRepository studentRepository;

	public String addAllStudents(List<Student> studentList) {
	
		Iterable<Student>allStudents=studentRepository.saveAll(studentList);
		
		if(allStudents!=null) {
			return "sucessfully added";
		}
		return "Not added";
	}

	public void updateStudentDeptById(String department, String id) {
		
		studentRepository.updateStudentDeptBYId(department,id);
		
	}

	public void deleteById(String id) {
		
		Long longId=Long.parseLong(id);
		
		studentRepository.deleteById(longId);;
		
	}

	public Iterable<Student> getAllStudents() {
		
		return studentRepository.findAll();
	}
	

	public Student getStudentById(Long id) {
		
		Optional<Student>student= studentRepository.findById(id);
		
		if(student.isPresent()) {
			
			return student.get();
		}
		
		return null;
	}
	
	
}
