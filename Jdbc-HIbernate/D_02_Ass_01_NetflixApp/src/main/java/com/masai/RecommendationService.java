package com.masai;

public class RecommendationService implements Services{

	ContentService contentService;
	
	
	
	public void setContentService(ContentService contentService) {
		this.contentService = contentService;
	}



	public void recommendationServic() {
		System.out.println("inside RecommendationService");
	}



	@Override
	public void service() {
		recommendationServic();
		
	}
	
}
