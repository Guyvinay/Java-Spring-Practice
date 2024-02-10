package com.app.modal;

public class DTOReq {

	private String title;
	private String description;
	
	public DTOReq(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	public DTOReq() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
