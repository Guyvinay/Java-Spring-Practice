package com.masaischool.service;

import java.util.List;

import com.masaischool.dto.StudentDTO;
import com.masaischool.entity.Student;
import com.masaischool.exception.StudentNotFoundException;

public interface StudentService {
	public Student addStudent(Student st);
	public List<Student> viewAllStudents();
	public Student viewStudentByRoll(Long roll) throws StudentNotFoundException;
	public Student updateStudent(Student st) throws StudentNotFoundException;
	public Student updateMarksByRoll(Long roll, Integer marks) throws StudentNotFoundException;
	public Student deleteStudent(Long roll) throws StudentNotFoundException;
	
	public List<Student> findByName(String name);
	public List<Student> findByMarksGreaterThanOrRollLessThanEqual(Integer marks, Long roll);
	
	public List<Student> findByNamePattern(String name);
	public List<StudentDTO> findByMarksMoreThan(Integer marks);
	
	//06-07-2023
	public List<Student> findTwoStudentByMarksMoreThan(int marks);
	public List<Student> findThreeByRollAsc();
	public List<Student> findStudentSorted(String field, String direction);
	public List<Student> findStudentByMarksSorted(Integer marks, String fieldOne, String directionOne, String fieldTwo, String directionTwo);
	public List<Student> findStudentPageWise(Integer pageNumber, Integer recordsPerPage);
}
