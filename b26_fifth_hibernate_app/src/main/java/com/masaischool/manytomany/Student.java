package com.masaischool.manytomany;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {	//Owning side
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String email;
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "students_courses", 
				joinColumns = {@JoinColumn(referencedColumnName = "id")},
				inverseJoinColumns = {@JoinColumn(referencedColumnName = "id")})
	private Set<Course> courses; 
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String email, String name, String lastName, Set<Course> courses) {
		super();
		this.email = email;
		this.name = name;
		this.courses = courses;
	}

	public long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}  
}
