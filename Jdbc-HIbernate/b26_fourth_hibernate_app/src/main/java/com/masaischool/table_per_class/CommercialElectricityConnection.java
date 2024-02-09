package com.masaischool.table_per_class;

import jakarta.persistence.Entity;

@Entity
public class CommercialElectricityConnection extends ElectricityConnection {
	private double valueAddedTax;
	private double fixCharge;
	public CommercialElectricityConnection() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommercialElectricityConnection(int id, int unitConsumed, double unitCharges, double valueAddedTax,
			double fixCharge) {
		super(id, unitConsumed, unitCharges);
		this.valueAddedTax = valueAddedTax;
		this.fixCharge = fixCharge;
	}
	public double getValueAddedTax() {
		return valueAddedTax;
	}
	public void setValueAddedTax(double valueAddedTax) {
		this.valueAddedTax = valueAddedTax;
	}
	public double getFixCharge() {
		return fixCharge;
	}
	public void setFixCharge(double fixCharge) {
		this.fixCharge = fixCharge;
	}
}
