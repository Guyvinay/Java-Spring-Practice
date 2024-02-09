package com.app.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@jakarta.persistence.Entity
@NoArgsConstructor
@Getter
@Setter
public class Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonProperty("API")
	private String API;
	@JsonProperty("Description")
	private String Description;
	@JsonProperty("Link")
	private String Link;
	@JsonProperty("Category")
	private String Category;
	
	public Entity(String aPI, String description, String link, String category) {
		super();
		API = aPI;
		Description = description;
		Link = link;
		Category = category;
	}
	
	
}
