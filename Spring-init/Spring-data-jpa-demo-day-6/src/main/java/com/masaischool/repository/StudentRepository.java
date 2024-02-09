package com.masaischool.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masaischool.dto.StudentDTO;
import com.masaischool.entity.Student;

@Repository	//Optional it is
public interface StudentRepository extends JpaRepository<Student, Long> {
	//findByXXX
	//this method will return List of students whose name is same as specified in the parameter
	public List<Student> findByName(String name);	//FROM student st WHERE st.name = ?
	public List<Student> findByMarksLessThan(Integer marks);	//FROM student st WHERE st.marks < ?
	public List<Student> findByMarksLessThanAndNameContains(Integer marks, String name);	//FROM student st WHERE st.marks < ? AND st.name LIKE %?%
	public List<Student> findByMarksGreaterThanOrRollLessThanEqual(Integer marks, Long roll);	//FROM student WHERE marks >= ? OR roll <= ?
	
	@Query("SELECT s FROM Student s WHERE s.name LIKE :pattern")	//named parameter
	public List<Student> findByNamePattern(@Param("pattern") String pattern);
	//in line 25 how Dto is working
	//@Query("SELECT s.name, s.marks FROM Student s WHERE marks > ?1")	//positional parameter
	@Query("SELECT new com.masaischool.dto.StudentDTO(s.name, s.marks) FROM Student s WHERE marks > ?1")	//positional parameter
	public List<StudentDTO> findByMarksMoreThan(Integer marks);
	
	//@Query("SELECT s.name FROM Student s WHERE marks > ?1")
	//public List<String> findByMarksMoreThan(Integer marks);
	
	//@Query("SELECT s FROM Student s WHERE marks > ?1")	//positional parameter
	//public List<Student> findByMarksMoreThan(Integer marks);
	
	//06-04-2023
	public List<Student> findTop2ByMarksGreaterThan(int marks);	//From Student st WHERE marks > value limit 0,2
	public List<Student> findTop3ByOrderByRollAsc();	//From Student st ORDER BY st.roll limit 0,3
	
	public List<Student> findByMarksGreaterThan(Integer marks, Sort sort);
}
//Spring data JPA will automatically create implementing class for this interface
//object of implementing class will be created by spring data jpa and it will be registered with
//the container
//so object of implementing class will be available for autowiring