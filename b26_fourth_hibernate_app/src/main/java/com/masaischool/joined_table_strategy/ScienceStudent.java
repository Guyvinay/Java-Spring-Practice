package com.masaischool.joined_table_strategy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class ScienceStudent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double physicsMarks;
	private double chemistryMarks;
	public ScienceStudent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ScienceStudent(double physicsMarks, double chemistryMarks) {
		super();
		this.physicsMarks = physicsMarks;
		this.chemistryMarks = chemistryMarks;
	}
	public int getId() {
		return id;
	}
	public double getPhysicsMarks() {
		return physicsMarks;
	}
	public void setPhysicsMarks(double physicsMarks) {
		this.physicsMarks = physicsMarks;
	}
	public double getChemistryMarks() {
		return chemistryMarks;
	}
	public void setChemistryMarks(double chemistryMarks) {
		this.chemistryMarks = chemistryMarks;
	}
}
