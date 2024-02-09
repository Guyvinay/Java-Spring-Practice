package com.masaischool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masaischool.dto.StudentDTO;
import com.masaischool.entity.Student;
import com.masaischool.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/students")
	public ResponseEntity<Student> addStudent(@RequestBody Student st) {
		Student student = studentService.addStudent(st);
		return new ResponseEntity<Student>(student, HttpStatus.CREATED);
	}
	/**
	 * [POST] http://localhost:8080/students
	 * {"name": "ABC", "marks": 96}
	 * 
	 * Response
	 * {"roll": 1, "name": "ABC", "marks": 96}
	 */
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> listStudents = studentService.viewAllStudents();
		return new ResponseEntity<List<Student>>(listStudents, HttpStatus.OK);
	}
	
	/**
	 * [GET] http://localhost:8080/students
	 * Response
	 * [
	 * 	{"roll": 1, "name": "ABC", "marks": 96},
	 * 	{"roll": 2, "name": "BCD", "marks": 89}
	 * ]
	 */
	
	@GetMapping("/students/{roll}")
	public ResponseEntity<Student> getStudent(@PathVariable Long roll){
		Student student = studentService.viewStudentByRoll(roll);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	/**
	 * [GET] http://localhost:8080/students/1
	 * Response: {"roll": 1, "name": "ABC", "marks": 96}
	 * 
	 * [GET] http://localhost:8080/students/100
	 * {"timestamp":"2023-07-05T22:08:55.4365297","message":"No student found for roll no 100","description":"uri=/students/100"}
	 */
	
	@PutMapping("/students")
	public ResponseEntity<Student> updateStudent(@RequestBody Student st) {
		Student student = studentService.updateStudent(st);
		return new ResponseEntity<Student>(student, HttpStatus.ACCEPTED);
	}
	
	/**
	 * [PUT] http://localhost:8080/students
	 * Request body: {"roll": 1, "name": "XYZ", "marks": 99}
	 * Response: {"roll": 1, "name": "XYZ", "marks": 99}
	 */
	
	@PatchMapping("/students/{roll}/{marks}")
	public ResponseEntity<Student> updateMarksByRoll(@PathVariable Long roll, @PathVariable Integer marks){
		Student st = studentService.updateMarksByRoll(roll, marks);
		return new ResponseEntity<Student>(st, HttpStatus.ACCEPTED);
	}
	
	/**
	 * [PATCH] http://localhost:8080/students/1/75
	 * {"roll":1,"name":"XYZ","marks":75}
	 */
	
	@DeleteMapping("/students/{roll}")
	public ResponseEntity<Student> deleteStudentByRollNumber(@PathVariable Long roll){
		Student st = studentService.deleteStudent(roll);
		return new ResponseEntity<Student>(st, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/students_by_name/{name}")
	public ResponseEntity<List<Student>> getAllStudentsByName(@PathVariable String name){
		List<Student> listStudents = studentService.findByName(name);
		return new ResponseEntity<List<Student>>(listStudents, HttpStatus.OK);
	}
	
	@GetMapping("/students/{marks}/{roll}")
	public ResponseEntity<List<Student>> findByMarksGreaterThanOrRollLessThanEqual(@PathVariable Integer marks, @PathVariable Long roll){
		List<Student> listStudents = studentService.findByMarksGreaterThanOrRollLessThanEqual(marks, roll);
		return new ResponseEntity<List<Student>>(listStudents, HttpStatus.OK);
	}
	
	@GetMapping("/students_by_name_pattern/{name}")
	public ResponseEntity<List<Student>> getAllStudentsByNamePattern(@PathVariable String name){
		List<Student> listStudents = studentService.findByNamePattern(name);
		return new ResponseEntity<List<Student>>(listStudents, HttpStatus.OK);
	}
	
	@GetMapping("/students_by_marks/{marks}")
	public ResponseEntity<List<StudentDTO>> getAllStudentsByMarksMoreThan(@PathVariable Integer marks){
		List<StudentDTO> listStudents = studentService.findByMarksMoreThan(marks);
		return new ResponseEntity<List<StudentDTO>>(listStudents, HttpStatus.OK);
	}
	
	//06-07-2023
	
	@GetMapping("/two_students_by_marks/{marks}")
	public ResponseEntity<List<Student>> getTwoStudentsByMarksMoreThan(@PathVariable Integer marks){
		List<Student> listStudents = studentService.findTwoStudentByMarksMoreThan(marks);
		return new ResponseEntity<List<Student>>(listStudents, HttpStatus.OK);
	}
	
	@GetMapping("/three_students_by_roll_asc")
	public ResponseEntity<List<Student>> getTwoStudentsByMarksMoreThan(){
		List<Student> listStudents = studentService.findThreeByRollAsc();
		return new ResponseEntity<List<Student>>(listStudents, HttpStatus.OK);
	}
	
	@GetMapping("/get_students_sorted/{field}/{order}")
	public ResponseEntity<List<Student>> getStudentSorted(@PathVariable String field, @PathVariable String order){
		List<Student> listStudents = studentService.findStudentSorted(field, order);
		return new ResponseEntity<List<Student>>(listStudents, HttpStatus.OK);
	}
	
	@GetMapping("/get_students_by_marks_sorted/{marks}/{fieldone}/{directionone}/{fieldtwo}/{directiontwo}")
	public ResponseEntity<List<Student>> getStudentByMarksSorted(@PathVariable Integer marks, @PathVariable String fieldone,
			@PathVariable String directionone, @PathVariable String fieldtwo,
			@PathVariable String directiontwo){
		List<Student> listStudents = studentService.findStudentByMarksSorted(marks, fieldone, directionone, fieldtwo, directiontwo);
		return new ResponseEntity<List<Student>>(listStudents, HttpStatus.OK);
	}
	
	@GetMapping("/get_students_page_wise/{pageNumber}/{recordsPerPage}")
	public ResponseEntity<List<Student>> findStudentPageWise(@PathVariable Integer pageNumber, @PathVariable Integer recordsPerPage){
		List<Student> listStudents = studentService.findStudentPageWise(pageNumber, recordsPerPage);
		return new ResponseEntity<List<Student>>(listStudents, HttpStatus.OK);
	}
}
