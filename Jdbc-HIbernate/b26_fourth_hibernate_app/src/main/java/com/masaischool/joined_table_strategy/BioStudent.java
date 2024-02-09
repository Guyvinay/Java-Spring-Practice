package com.masaischool.joined_table_strategy;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "bio_student_id")
public class BioStudent extends ScienceStudent {
	private double bioMarks;

	public BioStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BioStudent(double physicsMarks, double chemistryMarks, double bioMarks) {
		super(physicsMarks, chemistryMarks);
		this.bioMarks = bioMarks;
	}

	public double getBioMarks() {
		return bioMarks;
	}

	public void setBioMarks(double bioMarks) {
		this.bioMarks = bioMarks;
	}
}
