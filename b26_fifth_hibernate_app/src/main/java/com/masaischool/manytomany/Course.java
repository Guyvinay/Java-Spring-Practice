package com.masaischool.manytomany;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course {	//Inverse/Referencing side
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	  
	private String courseName;
	
	//Write code for many to many relationship with Student
	@ManyToMany(mappedBy = "courses")
	private Set<Student> students;
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String courseName, Set<Student> students) {
		super();
		this.courseName = courseName;
		this.students = students;
	}

	public long getId() {
		return id;
	}

	public String getCourseName() {
		return courseName;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}
