package com.masaischool.mapped_super_class;

import jakarta.persistence.Entity;

@Entity
public class HomeLoan extends Loan {
	private Double stampDuty;
	private Double subsidyAmount;
	
	public HomeLoan() {
		super();
	}
	
	public HomeLoan(Double principleAmount, Double timePeriod, Double interestRate, Double stampDuty,
			Double subsidyAmount) {
		super(principleAmount, timePeriod, interestRate);
		this.stampDuty = stampDuty;
		this.subsidyAmount = subsidyAmount;
	}

	public Double getStampDuty() {
		return stampDuty;
	}

	public void setStampDuty(Double stampDuty) {
		this.stampDuty = stampDuty;
	}

	public Double getSubsidyAmount() {
		return subsidyAmount;
	}

	public void setSubsidyAmount(Double subsidyAmount) {
		this.subsidyAmount = subsidyAmount;
	}
}
