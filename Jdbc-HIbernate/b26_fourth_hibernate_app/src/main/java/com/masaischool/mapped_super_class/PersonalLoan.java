package com.masaischool.mapped_super_class;

import jakarta.persistence.Entity;

@Entity
public class PersonalLoan extends Loan {
	private Double processingFee;
	private Double addOnTaxes;
	public PersonalLoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PersonalLoan(Double principleAmount, Double timePeriod, Double interestRate, Double processingFee,
			Double addOnTaxes) {
		super(principleAmount, timePeriod, interestRate);
		this.processingFee = processingFee;
		this.addOnTaxes = addOnTaxes;
	}
	
	public Double getProcessingFee() {
		return processingFee;
	}
	public void setProcessingFee(Double processingFee) {
		this.processingFee = processingFee;
	}
	
	public Double getAddOnTaxes() {
		return addOnTaxes;
	}
	public void setAddOnTaxes(Double addOnTaxes) {
		this.addOnTaxes = addOnTaxes;
	}
}
