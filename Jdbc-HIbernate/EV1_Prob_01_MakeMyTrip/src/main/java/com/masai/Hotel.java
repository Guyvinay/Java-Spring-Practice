package com.masai;

/*
 * hotelId;
	hotelName;
	location;
	rating;
	//use constructor injection to inject the above fields.
	//override the toString method with all the above fields
 */
public class Hotel {

	private int hotelId;
	private String hotelName;
	private String location;
	private double rating;
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hotel(int hotelId, String hotelName, String location, double rating) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.location = location;
		this.rating = rating;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", location=" + location + ", rating="
				+ rating + "]";
	}
	
	
}
