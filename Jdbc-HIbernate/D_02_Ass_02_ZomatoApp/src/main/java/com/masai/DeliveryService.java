package com.masai;


public class DeliveryService{

	OrderService orderService;

	Services ser;
	
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}


	public void setSer(Services ser) {
		this.ser = ser;
	}


	public void deliveryService() {
		System.out.println("inside DeliveryService");
		ser.service();
	}

	
	
}
