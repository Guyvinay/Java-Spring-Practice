package com.masaischool.mapped_super_class;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass	//No @Entity is here so no table will be created for the same
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double principleAmount;
	private Double timePeriod;
	private Double interestRate;
	
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Loan(Double principleAmount, Double timePeriod, Double interestRate) {
		super();
		this.principleAmount = principleAmount;
		this.timePeriod = timePeriod;
		this.interestRate = interestRate;
	}
	public Integer getId() {
		return id;
	}
	public Double getPrincipleAmount() {
		return principleAmount;
	}
	public void setPrincipleAmount(Double principleAmount) {
		this.principleAmount = principleAmount;
	}
	public Double getTimePeriod() {
		return timePeriod;
	}
	public void setTimePeriod(Double timePeriod) {
		this.timePeriod = timePeriod;
	}
	public Double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
}
