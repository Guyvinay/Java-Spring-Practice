package com.masai;

/*
 * 	packageId;
	packageName;
	duration;
	price;
	//use constructor injection to inject the above fields.
	//override the toString method with all the above fields
 */

public class Package {

	private int packageId;
	private String packageName;
	private int duration;
	private int price;
	public Package() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Package(int packageId, String packageName, int duration, int price) {
		super();
		this.packageId = packageId;
		this.packageName = packageName;
		this.duration = duration;
		this.price = price;
	}
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Package [packageId=" + packageId + ", packageName=" + packageName + ", duration=" + duration
				+ ", price=" + price + "]";
	}
	
	
	
}
