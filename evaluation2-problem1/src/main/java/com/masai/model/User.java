package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class User {
	
	private int userId;
	@NotBlank(message = "value should not be null")
	private String name;
	@Email(message = "email should be in proper format")
	private String email;
	private List<Integer> tweetList = new ArrayList<>();
	public User(int userId, @NotBlank String name,
			@Email String email) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Integer> getTweetList() {
		return tweetList;
	}

	public void setTweetList(List<Integer> tweetList) {
		this.tweetList = tweetList;
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", tweetList=" + tweetList +
				'}';
	}

	public User(int userId, String name, String email, List<Integer> tweetList) {
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.tweetList = tweetList;
	}

	public User() {

	}
}
