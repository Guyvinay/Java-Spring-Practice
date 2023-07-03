package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
public class Tweet {
	
	private int tweetId;
	@Min(value = 1 , message = "value should be greater than 1")
	private int userId;
	@NotBlank(message = "value should not be null")
	private String content;
	private List<Integer> retweetList = new ArrayList<>();
	private List<Integer> likeList = new ArrayList<>();
	
	public Tweet(int tweetId , int userId , String content) {
		this.tweetId = tweetId;
		this.userId = userId;
		this.content = content ;
	}

	public int getTweetId() {
		return tweetId;
	}

	public void setTweetId(int tweetId) {
		this.tweetId = tweetId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Integer> getRetweetList() {
		return retweetList;
	}

	public void setRetweetList(List<Integer> retweetList) {
		this.retweetList = retweetList;
	}

	public List<Integer> getLikeList() {
		return likeList;
	}

	public void setLikeList(List<Integer> likeList) {
		this.likeList = likeList;
	}

	public Tweet(int tweetId, int userId, String content, List<Integer> retweetList, List<Integer> likeList) {
		this.tweetId = tweetId;
		this.userId = userId;
		this.content = content;
		this.retweetList = retweetList;
		this.likeList = likeList;
	}

	public Tweet() {
	}

	@Override
	public String toString() {
		return "Tweet{" +
				"tweetId=" + tweetId +
				", userId=" + userId +
				", content='" + content + '\'' +
				", retweetList=" + retweetList +
				", likeList=" + likeList +
				'}';
	}
}
