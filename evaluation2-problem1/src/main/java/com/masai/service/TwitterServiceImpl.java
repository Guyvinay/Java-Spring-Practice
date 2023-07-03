package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Like;
import com.masai.model.Retweet;
import com.masai.model.Tweet;
import com.masai.model.User;
import com.masai.repository.TweeterRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class TwitterServiceImpl implements TweeterService{

	@Autowired
	private TweeterRepository tweeterRepository;

	@Override
	public User adduser(User user) {
		return tweeterRepository.adduser(user);
	}

	@Override
	public Tweet addTweet(int userId , Tweet tweet) {
		return tweeterRepository.addTweet(userId,tweet) ;
	}

	@Override
	public Like likeTweet(int userId , int tweetId) {
		return tweeterRepository.likeTweet(userId,tweetId);
	}

	@Override
	public Retweet retweetTweet(int userId , int tweetId) {
		return tweeterRepository.retweetTweet(userId,tweetId);
	}

	@Override
	public List<Tweet> getAllTweet(int userId){
		return tweeterRepository.getAllTweet(userId);
	}
	
	

}
