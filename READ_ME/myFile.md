# Welcome to readme-md-generator &#x1F44B; 
![example workflow](https://img.shields.io/badge/Eclipse-Version%3A%202022--09%20(4.25.0)-orange)
![example workflow](https://img.shields.io/badge/SpringBoot-2.2.1-yellowgreen)
![example workflow](https://img.shields.io/badge/Java-8-yellowgreen)
![example workflow](https://img.shields.io/badge/Postman-v10.13-orange)
![example workflow](https://img.shields.io/badge/Documentation-Yes-green)
![example workflow](https://img.shields.io/badge/Manitained%3F-Yes-green)
 >CLI that generate beautiful **ReadME**.md files

  :house:  <b><span style="color: blue;">Homepage</span></b>
  


 # Prerequisties

 - **Eclipse >=4.55.0**
 - **Postman >=10.13**
 


# Install
```
Maven Install
SpringTool Install
```
 # Framework And Language

 - **Framework :  SpringBoot**
 - **Language :  Java**

 # Dependencies Required

 - **spring-boot-starter-validation**
 - **spring-boot-starter-web**
 - **spring-boot-devtools**
 - **lombok**
 - **spring-boot-starter-test**
 - **spring-boot-starter-data-jpa**
 - **com.h2database**

# DataFlow For Student

<b><span style="color: white;">Controller</span></b>

1. *@PostMapping("/add")*

```
public String addAllStudent(@Valid @RequestBody List<Student>studentList) {
		
		
		return studentServices.addAllStudents(studentList);
		
	}
```
2. *@PutMapping("/update/{department}/id/{id}")*

```
public void updateStudentDepById(@PathVariable("department") String department,@PathVariable("id") String id) {
		
		
		 studentServices.updateStudentDeptById( department,id);
		
	}
```
3. *@DeleteMapping("/delete/id/{id}")*

```
public void deleteStudentById(@PathVariable("id") String id) {
		
		studentServices.deleteById(id);
	}
```
4. *@GetMapping("all")*

```
public Iterable<Student>getAllStudents(){
		return studentServices.getAllStudents();
	}
```
5. *@GetMapping("id/{id}")*

```
public Student getStudentById(@PathVariable ("id") Long id) {
		
		return studentServices.getStudentById(id);
	}
```



<b><span style="color: white;">Services</span></b>

1. *addAllStudents*

```
public String addAllStudents(List<Student> studentList) {
	
		Iterable<Student>allStudents=studentRepository.saveAll(studentList);
		
		if(allStudents!=null) {
			return "sucessfully added";
		}
		return "Not added";
	}
```

2. *updateStudentDeptById*

```
public void updateStudentDeptById(String department, String id) {
		
		studentRepository.updateStudentDeptBYId(department,id);
		
	}
```
3. *deleteById*

```
public void deleteById(String id) {
		
		Long longId=Long.parseLong(id);
		
		studentRepository.deleteById(longId);;
		
	}
```
4. *getAllStudents*

```
public Iterable<Student> getAllStudents() {
		
		return studentRepository.findAll();
	}
```
5. *getStudentById*

```
public Student getStudentById(Long id) {
		
		Optional<Student>student= studentRepository.findById(id);
		
		if(student.isPresent()) {
			
			return student.get();
		}
		
		return null;
	}
```


<b><span style="color: white;">Repository</span></b>

```

public interface StudentRepository extends CrudRepository<Student, Long>{

	
	
	@Modifying
	@Transactional
	@Query(
			
			value = "update tbl_student set department_type=:department where student_id=:id",
			nativeQuery = true
			)
	void updateStudentDeptBYId(String department, String id);

}
```

# DataFlow For Event

<b><span style="color: white;">Controller</span></b>

1. *@PostMapping("/add")*

```
public String addAllEvents(@Valid @RequestBody List<Event>listOfEvents) {
		
		
		return eventServices.addAllEvents(listOfEvents);
		
	}
```
2. *@PutMapping("/update/eventname/{eventname}/id/{id}")*

```
public void updateEventNameByid(@PathVariable("eventname") String eventname,@PathVariable ("id") String id) {
		
		eventServices.updateEventNameById(eventname,id);
		
		
	}
```
3. *@DeleteMapping("/delete/id/{id}")*

```
public void deleteEventById(@PathVariable ("id") Long id) {
		
		eventServices.deleteEventById(id);
	}
```
4. *@GetMapping("/date/{date}")*

```
public List<Event>getAllEventAftertheseDate(@PathVariable ("date") String date){
		
		
		return eventServices.getAllEventAfterTheseDate(date);
	}
```


<b><span style="color: white;">Services</span></b>

1. *addAllEvents*

```
public String addAllEvents(@Valid List<Event> listOfEvents) {
	
		
		Iterable<Event>allEvent=eventRepository.saveAll(listOfEvents);
		
		if(allEvent!=null) {
			return "Sucessfully Added";
		}
		return "not  added";
	}
```

2. *updateEventNameById*

```
public void updateEventNameById(String eventname,String id) {
		
		eventRepository.updateEventNameWhereIdIs(eventname, id);
		
		
	}
```
3. *deleteEventById*

```
public void deleteEventById(Long id) {
	
		
		eventRepository.deleteById(id);
		
	}
```
4. *getAllEventAfterTheseDate*

```
public List<Event> getAllEventAfterTheseDate(String date) {
	
		return eventRepository.getAllEventAfterDate(date);
	}
```

<b><span style="color: white;">Repository</span></b>

```

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
```




	
	


  


	







	



# Database Used

<details>
<summary><b><span style="color: white;">Clickme</span></b> &#x1F4F2; </summary>

*h2Database*



</details>

 # Database Design For Student Model

 - **Primary Key :  student_id**
 - **Generationstrategy:  Sequence**
 - **Columns Used:  student_id,first_name , last_name,student_age, student_department**

 # Database Design For Event Model

 - **Primary Key :  event_id**
 - **Generationstrategy:  Sequence**
 - **Columns Used:  event_id,event_name , event_location,event_date,start_time,end_time**




# Summary

 Spring Project that is a  University Event Management.
The model will have the following attribute
**studentid**,
**firstname**,
**lstname**,
**studentage**,
**studentdepartment**,
**eventid**,
**eventname**,
**eventlocation**,
**eventdate**,
**starttime**,
**endtime**
. Along with these proper validations are also provided.Used CRUD operation,Custom finders and Custom Query
to do necessary operations.






# :handshake:  Contributing
  Contributions,issues and features request are welcome! 
  

  #


  This *README* was generated with &#x2764;&#xFE0F; by <b><span style="color: blue;">readme-md-generator</span></b> 










   
  
  

