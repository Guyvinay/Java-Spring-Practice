package com.masai.Exception;

import java.time.LocalDateTime;

public class ErrorDetail {

	private String message;
	private String description;
	private LocalDateTime dateTime;
	public ErrorDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorDetail(String message, String description, LocalDateTime dateTime) {
		super();
		this.message = message;
		this.description = description;
		this.dateTime = dateTime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	
}
