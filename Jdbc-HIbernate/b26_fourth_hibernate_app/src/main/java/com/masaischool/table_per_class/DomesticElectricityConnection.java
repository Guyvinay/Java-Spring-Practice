package com.masaischool.table_per_class;

import jakarta.persistence.Entity;

@Entity
public class DomesticElectricityConnection extends ElectricityConnection {
	private double electricityDuty;

	public DomesticElectricityConnection() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DomesticElectricityConnection(int id, int unitConsumed, double unitCharges, double electricityDuty) {
		super(id, unitConsumed, unitCharges);
		this.electricityDuty = electricityDuty;
	}

	public double getElectricityDuty() {
		return electricityDuty;
	}

	public void setElectricityDuty(double electricityDuty) {
		this.electricityDuty = electricityDuty;
	}
}
