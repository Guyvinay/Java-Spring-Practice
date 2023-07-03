package com.masai.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {

	private String message;
	private String description;
	private LocalDateTime timeStemp = LocalDateTime.now();
	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorDetails(String message, String description, LocalDateTime timeStemp) {
		super();
		this.message = message;
		this.description = description;
		this.timeStemp = timeStemp;
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
	public LocalDateTime getTimeStemp() {
		return timeStemp;
	}
	public void setTimeStemp(LocalDateTime timeStemp) {
		this.timeStemp = timeStemp;
	}
	
}
