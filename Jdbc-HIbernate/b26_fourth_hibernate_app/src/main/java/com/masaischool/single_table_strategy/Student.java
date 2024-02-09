package com.masaischool.single_table_strategy;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ST")
public class Student extends Human {
	private String course;
	private String institutionName;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, double weight, String course, String institutionName) {
		super(name, weight);
		this.course = course;
		this.institutionName = institutionName;
	}
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
}
