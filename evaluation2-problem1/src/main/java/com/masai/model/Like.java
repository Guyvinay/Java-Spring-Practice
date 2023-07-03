package com.masai.model;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Like {
	
	private int likeId;
	@Min(value = 1 , message = "value should be greater than 1")
	private int userId;
	@Min(value = 1 , message = "value should be greater than 1")
	private int tweetId;

	public int getLikeId() {
		return likeId;
	}

	public void setLikeId(int likeId) {
		this.likeId = likeId;
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

	public Like(int likeId, int userId, int tweetId) {
		this.likeId = likeId;
		this.userId = userId;
		this.tweetId = tweetId;
	}

	@Override
	public String toString() {
		return "Like{" +
				"likeId=" + likeId +
				", userId=" + userId +
				", tweetId=" + tweetId +
				'}';
	}

	public Like() {
	}
}
