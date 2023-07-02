package com.masaischool.spring_boot_day_02;

import java.time.LocalDateTime;

public class MyErrorDetails {
	private String message;
	private String description;
	private LocalDateTime exceptionDateTime;
	
	public MyErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyErrorDetails(String message, String description, LocalDateTime exceptionDateTime) {
		super();
		this.message = message;
		this.description = description;
		this.exceptionDateTime = exceptionDateTime;
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

	public LocalDateTime getExceptionDateTime() {
		return exceptionDateTime;
	}

	public void setExceptionDateTime(LocalDateTime exceptionDateTime) {
		this.exceptionDateTime = exceptionDateTime;
	}
}
