package com.masaischool.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masaischool.dto.StudentDTO;
import com.masaischool.entity.Student;
import com.masaischool.exception.StudentNotFoundException;
import com.masaischool.repository.StudentRepository;

@Service	//Here Mandatory it is
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;	//this will be resolved by the autowiring byType
	
	@Override
	public Student addStudent(Student st) {
		return studentRepository.save(st);
	}

	@Override
	public List<Student> viewAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student viewStudentByRoll(Long roll) throws StudentNotFoundException {
		Optional<Student> opStu = studentRepository.findById(roll);
		/*
			if(!opStu.isPresent()) {
				throw new StudentNotFoundException("No student found for roll no " + roll);
			}
			//you are here means student found for given roll number
			Student st = opStu.get();	//getting the object from Optional object
			return st;	//return the object from the method
		*/
		//the same code can be written as
		return opStu.orElseThrow(() -> new StudentNotFoundException("No student found for roll no " + roll));
	}

	@Override
	public Student updateStudent(Student st) {
		//Get student or throw exception
		Student student = studentRepository.findById(st.getRoll()).
				orElseThrow(() -> new StudentNotFoundException("No student found for roll no " + st.getRoll()));
		//stuff the details
		student.setName(st.getName());
		student.setMarks(st.getMarks());
		//return the updated instance
		return studentRepository.save(student);
	}

	@Override
	public Student updateMarksByRoll(Long roll, Integer marks) {
		//Get student or throw exception
		Student student = studentRepository.findById(roll).
				orElseThrow(() -> new StudentNotFoundException("No student found for roll no " + roll));
		student.setMarks(marks);
		return studentRepository.save(student);
	}

	@Override
	public Student deleteStudent(Long roll) {
		///Get student or throw exception
		Student student = studentRepository.findById(roll).
				orElseThrow(() -> new StudentNotFoundException("No student found for roll no " + roll));
		studentRepository.delete(student);
		return student;
	}
	
	@Override
	public List<Student> findByName(String name){
		return studentRepository.findByName(name);
	}
	
	@Override
	public List<Student> findByMarksGreaterThanOrRollLessThanEqual(Integer marks, Long roll){
		return studentRepository.findByMarksGreaterThanOrRollLessThanEqual(marks, roll);
	}
	
	@Override
	public List<Student> findByNamePattern(String name){
		return studentRepository.findByNamePattern("%" + name + "%");
	}
	
	@Override
	public List<StudentDTO> findByMarksMoreThan(Integer marks){
		return studentRepository.findByMarksMoreThan(marks);
	}
	
	@Override
	public List<Student> findTwoStudentByMarksMoreThan(int marks){
		return studentRepository.findTop2ByMarksGreaterThan(marks);
	}
	
	@Override
	public List<Student> findThreeByRollAsc(){
		return studentRepository.findTop3ByOrderByRollAsc();
	}
	
	/**
	 * possible value of direction: ASC or DESC
	 */
	@Override
	public List<Student> findStudentSorted(String field, String direction){
		//Create an object of Sort class according to given field
		Sort sort = null;
		
		if(direction.equalsIgnoreCase("ASC")) {
			sort = Sort.by(Sort.Direction.ASC, field);
		}else {
			sort = Sort.by(Sort.Direction.DESC, field);
		}
		
		return studentRepository.findAll(sort);
	}
	
	//SELECT s FROM Student s ORDER BY s.name DESC, s.marks ASC
	@Override
	public List<Student> findStudentByMarksSorted(Integer marks, String fieldOne, String directionOne, String fieldTwo, String directionTwo){
		//Create an object of Sort class according to given field
		//Sort sort = Sort.by(direction.equalsIgnoreCase("asc")?Sort.Direction.ASC:Sort.Direction.DESC, fieldOne, fieldTwo);
		
		//is same as
		
		Sort sort = Sort.by(directionOne.equalsIgnoreCase("asc")?Sort.Direction.ASC:Sort.Direction.DESC, fieldOne);
		sort = sort.and(Sort.by(directionTwo.equalsIgnoreCase("asc")?Sort.Direction.ASC:Sort.Direction.DESC, fieldTwo));
		
		return studentRepository.findByMarksGreaterThan(marks, sort);
	}
	
	@Override
	public List<Student> findStudentPageWise(Integer pageNumber, Integer recordsPerPage){
		//Create an object of PageRequest
		Pageable pageable = PageRequest.of(pageNumber, recordsPerPage);
		return studentRepository.findAll(pageable).getContent();
	}
}
