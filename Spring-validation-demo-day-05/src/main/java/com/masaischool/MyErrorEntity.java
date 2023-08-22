package com.masaischool;

import java.time.LocalDateTime;

public class MyErrorEntity {
	private LocalDateTime timestamp;
	private String message;
	private String description;
	
	public MyErrorEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyErrorEntity(LocalDateTime timestamp, String message, String description) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.description = description;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
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
}
