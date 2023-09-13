package com.app.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Entities {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String API;
	
	private String Description;
	
	private String Auth;
	
	private String HTTPS;
	
	private String Cors;
	
	private String Link;
	
	private String Category;

	public Entities(String aPI, String description, String auth, String hTTPS, String cors, String link,
			String category) {
		super();
		API = aPI;
		Description = description;
		Auth = auth;
		HTTPS = hTTPS;
		Cors = cors;
		Link = link;
		Category = category;
	}
	
	
	
}
