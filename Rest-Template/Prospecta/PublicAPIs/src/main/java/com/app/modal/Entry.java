package com.app.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entry {
	
	@JsonProperty("API")
	private String API;
	@JsonProperty("Description")
	private String Description;
	@JsonProperty("Link")
	private String Link;
	@JsonProperty("Category")
	private String Category;
}
