package com.masai;

public class OrderService implements Services {

	
	RestaurantService restaurantService;
	
	
	
	public void setRestaurantService(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}



	public void orderService() {
		System.out.println("inside OrderService");
	}



	@Override
	public void service() {
		orderService();
		
	}
	
}
