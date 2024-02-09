package com.masaischool.table_per_class;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ElectricityConnection {
	@Id
	private int id;
	private int unitConsumed;
	private double unitCharges;
	public ElectricityConnection() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ElectricityConnection(int id, int unitConsumed, double unitCharges) {
		super();
		this.id = id;
		this.unitConsumed = unitConsumed;
		this.unitCharges = unitCharges;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUnitConsumed() {
		return unitConsumed;
	}
	public void setUnitConsumed(int unitConsumed) {
		this.unitConsumed = unitConsumed;
	}
	public double getUnitCharges() {
		return unitCharges;
	}
	public void setUnitCharges(double unitCharges) {
		this.unitCharges = unitCharges;
	}	
}
