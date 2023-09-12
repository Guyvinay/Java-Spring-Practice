package com.app.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Entities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonProperty("API")
	private String API;
	@JsonProperty("Description")
	private String Description;
	@JsonProperty("Auth")
	private String Auth;
	@JsonProperty("HTTPS")
	private String HTTPS;
	@JsonProperty("Cors")
	private String Cors;
	@JsonProperty("Link")
	private String Link;
	@JsonProperty("Category")
	private String Category;
	
	public Entities() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	
	public int getId() {
		return id;
	}
	public String getAPI() {
		return API;
	}
	public void setAPI(String aPI) {
		API = aPI;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getAuth() {
		return Auth;
	}
	public void setAuth(String auth) {
		Auth = auth;
	}
	public String getHTTPS() {
		return HTTPS;
	}
	public void setHTTPS(String hTTPS) {
		HTTPS = hTTPS;
	}
	public String getCors() {
		return Cors;
	}
	public void setCors(String cors) {
		Cors = cors;
	}
	public String getLink() {
		return Link;
	}
	public void setLink(String link) {
		Link = link;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	
	@Override
	public String toString() {
		return "Entities [id=" + ", API=" + API + ", Description=" + Description + ", Auth=" + Auth + ", HTTPS="
				+ HTTPS + ", Cors=" + Cors + ", Link=" + Link + ", Category=" + Category + "]";
	}
}
