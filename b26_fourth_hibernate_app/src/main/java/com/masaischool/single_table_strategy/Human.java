package com.masaischool.single_table_strategy;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)	//this line is optional
//this time column name will be human_profession instead of DTYPE
//data type of human_profession is String
@DiscriminatorColumn(name = "human_profession", discriminatorType = DiscriminatorType.STRING)
public class Human {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private double weight;
	public Human() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Human(String name, double weight) {
		super();
		this.name = name;
		this.weight = weight;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
}
