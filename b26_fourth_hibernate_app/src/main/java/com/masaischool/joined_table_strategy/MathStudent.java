package com.masaischool.joined_table_strategy;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "math_student_id")
public class MathStudent extends ScienceStudent {
	private double mathMarks;

	public MathStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MathStudent(double physicsMarks, double chemistryMarks, double mathMarks) {
		super(physicsMarks, chemistryMarks);
		this.mathMarks = mathMarks;
	}

	public double getMathMarks() {
		return mathMarks;
	}

	public void setMathMarks(double mathMarks) {
		this.mathMarks = mathMarks;
	}
}
