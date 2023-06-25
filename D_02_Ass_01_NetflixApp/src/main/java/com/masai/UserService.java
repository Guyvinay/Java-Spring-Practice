package com.masai;

public class UserService{

	RecommendationService recommendationService;
	
	Services services;
	
	public void setRecommendationService(RecommendationService recommendationService) {
		this.recommendationService = recommendationService;
	}
	

	public void setServices(Services services) {
		this.services = services;
	}


	public void userService() {
		System.out.println("inside UserService");
		services.service();
	}
	
	
}
