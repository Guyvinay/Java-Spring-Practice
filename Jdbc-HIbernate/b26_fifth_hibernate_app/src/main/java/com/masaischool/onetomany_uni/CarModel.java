package com.masaischool.onetomany_uni;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CarModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String modelNo;
	private double priceInLPA;
	
	public CarModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CarModel(String modelNo, double priceInLPA) {
		super();
		this.modelNo = modelNo;
		this.priceInLPA = priceInLPA;
	}
	
	public int getId() {
		return id;
	}
	public String getModelNo() {
		return modelNo;
	}
	
	public double getPriceInLPA() {
		return priceInLPA;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}
	public void setPriceInLPA(double priceInLPA) {
		this.priceInLPA = priceInLPA;
	}
}
