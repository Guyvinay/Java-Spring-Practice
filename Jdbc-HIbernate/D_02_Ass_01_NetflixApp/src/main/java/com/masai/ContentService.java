package com.masai;

public class ContentService implements Services {

	UserService  userService;
	
	
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}



	public void contentService() {
		System.out.println("inside contentService");
	}



	@Override
	public void service() {
		
		contentService();
		
	}
	
}
