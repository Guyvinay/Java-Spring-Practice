package com.app.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Entry {

	@JsonProperty(value = "API")
	private String API;
	@JsonProperty(value = "Description")
	private String Description;
	@JsonProperty(value = "Auth")
	private String Auth;
	@JsonProperty(value = "HTTPS")
	private String HTTPS;
	@JsonProperty(value = "Cors")
	private String Cors;
	@JsonProperty(value = "Link")
	private String Link;
	@JsonProperty(value = "Category")
	private String Category;
	
}
