package com.masaischool.manytoone_uni;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String categoryName;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
	}
	
	public int getId() {
		return id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
