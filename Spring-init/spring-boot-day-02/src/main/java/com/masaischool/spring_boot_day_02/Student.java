package com.masaischool.spring_boot_day_02;

public class Student {
	private Integer roll;
	private String name;
	private Integer marks;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Integer roll, String name, Integer marks) {
		super();
		this.roll = roll;
		this.name = name;
		this.marks = marks;
	}

	public Integer getRoll() {
		return roll;
	}

	public void setRoll(Integer roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}
}
