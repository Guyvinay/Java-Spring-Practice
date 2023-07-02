package com.masaischool.spring_boot_day_02;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController = @ResponseBody + @Controller
//@ResponseBody: this annotation says that the response is going to be a json response
@RestController
public class HelloController {
	//This method is for Printing the hello world message as json object on browser screen
	//Endpoint: http://localhost:8088/hello
	//@RequestMapping(method = RequestMethod.GET, value = "/hello")
	//@RequestMapping(value = "/hello")	//default value for method is RequestMethod.GET
	//@RequestMapping(method = RequestMethod.GET, value = "/hello", produces = "application/json")
	//@RequestMapping(method = RequestMethod.GET, value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(value = "/hello")
	public String sayHello() {
		return "Hello World!";
	}
	
	List<Student> list;
	List<Employee> empList;
	
	HelloController(){
		list = new ArrayList<>();
		list.add(new Student(21, "PQR", 95));
		list.add(new Student(22, "QRS", 97));
		list.add(new Student(23, "RST", 93));
		
		empList = new ArrayList<>();
		empList.add(new Employee(25, "ABC", 7.5));
		empList.add(new Employee(30, "BCD", 10.5));
		empList.add(new Employee(35, "CDE", 9.5));
	}
	
	//This method is to get details of Student on the browser screen
	//Endpoint: http://localhost:8088/student	(Not according to convention)
	@GetMapping(value = "/student")
	public Student getStudent() {
		//Create an object of Student
		Student st = new Student(10, "ABC", 95);
		return st;
	}
	
	//This method is to get details of Students on the browser screen as json objecy
	//Endpoint: http://localhost:8088/students	(According to convention)
	@GetMapping(value = "/students")
	public List<Student> getAllStudent() {
		//Create an object of Student
		List<Student> list = new ArrayList<>();
		list.add(new Student(11, "PIU", 95));
		list.add(new Student(12, "IUY", 93));
		list.add(new Student(13, "UYT", 97));
		return list;
	}
	
	//This method is to get a student by the roll
	//The variable names in the endpoint must be in the {}
	//Endpoint:: http://localhost:8088/students/{roll}
	@GetMapping(value = "/students/{roll}")
	public Student getStudentByRoll(@PathVariable Integer roll) {
//		Student st = null;
//		for(Student temp: list) {
//			if(temp.getRoll() == roll) {
//				st = temp;
//				break;
//			}
//		}
//		return st;	
		return list.stream().filter(stu -> (stu.getRoll() == roll)).toList().get(0);
	}
	
	//This method is to get a List of student by name or marks
	//if name of student contains value specified in parameter or marks of student is more than the value specified in parameter
	//Endpoint:: http://localhost:8088/students/{name}/{marks}
	@GetMapping(value = "/students/{name}/{marks}")
//	public List<Student> getStudentListByNameOrMarks(@PathVariable("name") String stName, 
//			@PathVariable(value = "marks") Integer minMarks){
//		return list.stream().filter(stu -> (stu.getName().contains(stName) || stu.getMarks() >= minMarks)).toList();
//	}
	public List<Student> getStudentListByNameOrMarks(@PathVariable Map<String, String> map){
		//map :: {name: 'value-from-URL', marks: 'value-from-URL'}
		return list.stream().
				filter(stu -> (stu.getName().contains(map.get("name")) || stu.getMarks() >=  Integer.parseInt(map.get("marks")))).
				toList();
	}
	
	//This method is to take the student whose marks are less than the value specified in query string
	//Endpoint:: http://localhost:8088/studentsunderamarks?maxmarks=<value>
	@GetMapping(value = "/studentsunderamarks")
	public List<Student> getStudentListUnderMarks(@RequestParam("maxmarks") Integer marks){
		return list.stream().filter(stu -> (stu.getMarks() <=  marks)).toList();
	}
	
	//Endpoint:: http://localhost:8088/students
	//@RequestMapping(method = RequestMethod.POST, value = "/students") is same as
	//@PostMapping(value = "/students") is same
	@PostMapping(value = "/students", consumes = "application/json")
	public String saveStudent(@RequestBody Student st) {
		list.add(st);
		return "Student added successfully";
	}
	
	/**
	 * [POST] http://localhost:8088/students
	 * {"roll" : 24, "name": "STU", "marks": 90}
	 * 
	 * [GET] http://localhost:8088/students/24
	 * {"roll" : 24, "name": "STU", "marks": 90}
	 * 
	 * [GET] http://localhost:8088/students/S/85
	 * [{"roll": 21, "name": "PQR", "marks": 95}, {"roll": 22, "name": "QRS", "marks": 97}, {"roll": 23,"name": "RST","marks": 93},
        {"roll": 24, "name": "STU", "marks": 90}]
	 */
	
	//Endpoint:: http://localhost:8088/students
	//@RequestMapping(method = RequestMethod.PUT, value = "/students") is same as
	//@PUTMapping(value = "/students") is same
	@PutMapping(value = "/students", consumes = "application/json")
	public String updateStudent(@RequestBody Student st) {
		//find the student with given roll number
		Student student = list.stream().filter(stu -> (stu.getRoll() == st.getRoll())).toList().get(0);
		//updating the details
		student.setName(st.getName());
		student.setMarks(st.getMarks());
		//returning the response
		return "Student updated successfully";
	}
	
	/**
	 * [GET] http://localhost:8088/students/23
	 * {"roll": 23,"name": "RST","marks": 93}
	 * 
	 * [PUT] http://localhost:8088/students
	 * {"roll": 23,"name": "XYZ","marks": 99}
	 * 
	 * [GET] http://localhost:8088/students/23
	 * {"roll": 23,"name": "XYZ","marks": 99}
	 */
	
	//Endpoint:: http://localhost:8088/students/{roll}
	@DeleteMapping(value = "students/{roll}")
	public String deleteStudent(@PathVariable("roll") Integer rollNumber) {
		//find the student with given roll number
		Student student = list.stream().filter(stu -> (stu.getRoll() == rollNumber)).toList().get(0);
		list.remove(student);
		return "Student deleted successfully";
	}
	
	/**
	 * [GET] http://localhost:8088/students/23
	 * {"roll": 23,"name": "RST","marks": 93}
	 * 
	 * [DELETE] http://localhost:8088/students/23
	 * Student deleted successfully
	 * 
	 * [GET] http://localhost:8088/students/23
	 * Exception
	 */
	
	
	
	//01-07-2023 (Day-08)
	
	
	//update details of student on the behalf of roll number
	//we may update name only, marks only or we can update both
	//Endpoing: http://localhost:8088/students/{roll}
	@PatchMapping(value = "/students/{roll}")
	public String updateStudentNameAndRoll(@PathVariable Integer roll, @RequestBody Map<String, Object> map) {
		//code to fetch student for the given roll
		Student student = list.stream().filter(stu -> (stu.getRoll() == roll)).toList().get(0);
		
		//case - 01: when only name is to be updated
		//case - 02: when name & marks both are to be updated
		//case - 03: when marks is to be updated
		if(map.get("name") != null) {
			//name is available in map so we have to update the same for student also
			student.setName((String)map.get("name"));
		}
		if(map.get("marks") != null) {
			//marks is available in map so we have to update the same for student also
			student.setMarks((Integer)map.get("marks"));
		}
		
		return "Student details updated suucessfully";
	}
	
	/**
	 * [GET] http://localhost:8088/students/23
	 * {roll: 23, name: RST, marks: 93}
	 * 
	 * [PATCH] http://localhost:8088/students/23
	 * {"name": "WER"}
	 * Student details updated suucessfully
	 * 
	 * [GET] http://localhost:8088/students/23
	 * {roll: 23, name: WER, marks: 93}
	 * 
	 * [PATCH] http://localhost:8088/students/23
	 * {"marks": 30}
	 * Student details updated suucessfully
	 * 
	 * [GET] http://localhost:8088/students/23
	 * {roll: 23, name: WER, marks: 30}
	 * 
	 * [PATCH] http://localhost:8088/students/23
	 * {"name": "RST", "marks": 93}
	 * Student details updated suucessfully
	 * 
	 * [GET] http://localhost:8088/students/23
	 * {roll: 23, name: RST, marks: 93}
	 */
	
	
	//RETURNING HTTP RESPONSE FROM THE methods
	
	//HTTP Response: body + header + status code
	//HttpEntity<T> = body + header (no status code)
	//https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/HttpEntity.html
	
	//ResponseEntity<T> = body + header + status code
	//https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/ResponseEntity.html
	
	//Enum HttpStatus
	//https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/HttpStatus.html
	
	//Httpheaders class
	//https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/HttpHeaders.html
	
	@GetMapping(value = "/hi_response")
	public ResponseEntity<String> getResponse(){
		return new ResponseEntity<String>("Hello World!", HttpStatus.OK);
	}
	
	/**
	 * [GET] http://localhost:8088/hi_response
	 */
	
	//Endpoint: http://localhost:8088/employees/{empid}
	@GetMapping(value = "/employees/{empid}")
	public ResponseEntity<String> getEmployeebyEmpId(@PathVariable("empid") Integer empId){
		List<Employee> employeeList = empList.stream().filter(emp -> emp.getEmpId() == empId).toList();
		
		if(employeeList.isEmpty())
			return new ResponseEntity<String>("No employee found for employee id " + empId, HttpStatus.BAD_REQUEST);
		
		//you are here means employee for given employee id exists
		return new ResponseEntity<String>(employeeList.get(0).toString(), HttpStatus.OK);
	}
	
	//this version returns header also
	//Endpoint: http://localhost:8088/employees/{empid}
//	@GetMapping(value = "/employees/{empid}")
//	public ResponseEntity<String> getEmployeebyEmpId(@PathVariable("empid") Integer empId){
//		List<Employee> employeeList = empList.stream().filter(emp -> emp.getEmpId() == empId).toList();
//		
//		if(employeeList.isEmpty())
//			return new ResponseEntity<String>("No employee found for employee id " + empId, HttpStatus.BAD_REQUEST);
//		
//		
//		//now this code is to send header
//		HttpHeaders httpHeaders = new HttpHeaders();
//		httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
//		httpHeaders.add("mymessage", "All is well");
//		return new ResponseEntity<String>(employeeList.get(0).toString(), httpHeaders ,HttpStatus.OK);
//	}
	
	/**
	 * [GET] http://localhost:8088/employees/25
	 * Employee [empId=25, name=ABC, salary=7.5]
	 * 
	 * [GET] http://localhost:8088/employees/26
	 */	
	
	
	//throw Exception if result is not according to criteria or invalid input
	@GetMapping(value = "/employees/{startsal}/{endsal}")
	public ResponseEntity<List<Employee>> getEmployeesForSalaryRange(@PathVariable("startsal") Double startsal, 
			@PathVariable("endsal") Double endsal){
		if(startsal >= endsal) {
			//this is invalid input values
			throw new IllegalArgumentException("Start salary must be less than the end salary");
		}
		
		//you are here means startSal < endSal
		List<Employee> employeeList = empList.stream().filter(emp -> emp.getSalary() >= startsal && emp.getSalary() <= endsal).toList();
		return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
	}
	
	/**
	 * [GET] http://localhost:8088/employees/6.5/12.0
	 * [{"empId":25,"name":"ABC","salary":7.5},{"empId":30,"name":"BCD","salary":10.5},{"empId":35,"name":"CDE","salary":9.5}]
	 * 
	 * [GET] http://localhost:8088/employees/10.0/12.0
	 * [{"empId":30,"name":"BCD","salary":10.5}]
	 * 
	 * [GET] http://localhost:8088/employees/12.0/10.0
	 * 
	 */

	//this code is just to handle IllegalArgumentException for the HelloController only.
	//for every controller we have to write the exception handler again and again which makes the code redundant and difficult to manage
//	@ExceptionHandler(IllegalArgumentException.class)
//	public ResponseEntity<String> myExceptionHandler(IllegalArgumentException ex){
//		System.out.println("Inside myExceptionHandler");
//		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//	}
	
	//Solution: Writing the common controller to handle exception
	//better to comment the above code
	//refer to file GlobalExceptionHandler.java
	
	@GetMapping(value = "/employees")
	public ResponseEntity<List<Employee>> getEmployeeByName(@RequestParam(required = false) String name){
		if(name == null || name.length() == 0) {
			throw new InvalidNameException("Name must be provided and it cannot be empty");
		}
		
		List<Employee> employeeList = empList.stream().filter(emp -> emp.getName().equals(name)).toList();
		if(employeeList.isEmpty()) {
			throw new InvalidNameException("no Employee found for the name " + name);
		}
		return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
	}
	
	
	/**
	 * [GET] http://localhost:8088/employees
	 * Name must be provided and it cannot be empty
	 * 
	 * [GET] http://localhost:8088/employees?name=abc
	 * no Employee found for the name abc
	 * 
	 * [GET] http://localhost:8088/employees?name=BCD
	 * [{"empId":30,"name":"BCD","salary":10.5}]
	 */
}
