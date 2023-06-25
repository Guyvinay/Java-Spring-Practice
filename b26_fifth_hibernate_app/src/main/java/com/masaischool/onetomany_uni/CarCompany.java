package com.masaischool.onetomany_uni;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class CarCompany {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String companyName;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "car_company_id")
	private Set<CarModel> models;
	
	public CarCompany() {
		super();
	}
	public CarCompany(String companyName, Set<CarModel> models) {
		super();
		this.companyName = companyName;
		this.models = models;
	}
	
	public int getId() {
		return id;
	}
	public String getCompanyName() {
		return companyName;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public Set<CarModel> getModels() {
		return models;
	}
	public void setModels(Set<CarModel> models) {
		this.models = models;
	}
}
