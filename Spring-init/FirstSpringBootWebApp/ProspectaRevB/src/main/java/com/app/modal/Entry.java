package com.app.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Entry {

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
	
}
