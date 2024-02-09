package com.masai.model;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Retweet {

	private int retweetId;
	@Min(value = 1 , message = "value should be greater than 1")
	private int userId;
	@Min(value = 1 , message = "value should be greater than 1")
	private int tweetId;

	public int getRetweetId() {
		return retweetId;
	}

	public void setRetweetId(int retweetId) {
		this.retweetId = retweetId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTweetId() {
		return tweetId;
	}

	public void setTweetId(int tweetId) {
		this.tweetId = tweetId;
	}

	@Override
	public String toString() {
		return "Retweet{" +
				"retweetId=" + retweetId +
				", userId=" + userId +
				", tweetId=" + tweetId +
				'}';
	}

	public Retweet() {
	}

	public Retweet(int retweetId, int userId, int tweetId) {
		this.retweetId = retweetId;
		this.userId = userId;
		this.tweetId = tweetId;
	}
}
