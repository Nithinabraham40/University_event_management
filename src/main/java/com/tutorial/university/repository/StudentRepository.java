package com.tutorial.university.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tutorial.university.model.Student;

import jakarta.transaction.Transactional;

public interface StudentRepository extends CrudRepository<Student, Long>{

	
	
	@Modifying
	@Transactional
	@Query(
			
			value = "update tbl_student set department_type=:department where student_id=:id",
			nativeQuery = true
			)
	void updateStudentDeptBYId(String department, String id);

}
