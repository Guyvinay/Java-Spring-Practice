package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Like;
import com.masai.model.Retweet;
import com.masai.model.Tweet;
import com.masai.model.User;
import com.masai.service.TwitterServiceImpl;
import jakarta.validation.Valid;

@RestController
public class TweeterController {
	
	@Autowired
	private TwitterServiceImpl twitterServiceImpl;
	
	@PostMapping("/users")
	public ResponseEntity<User> ragisterUserHandler(@Valid  @RequestBody User user){
		return new ResponseEntity<>(twitterServiceImpl.adduser(user) , HttpStatus.ACCEPTED) ;
	}
	
	
	@PostMapping("/tweets/{userId}")
	public ResponseEntity<Tweet> addTweetHandler(@PathVariable Integer userId , @Valid @RequestBody Tweet tweet ){
		return new ResponseEntity<>(twitterServiceImpl.addTweet(userId, tweet ) , HttpStatus.CREATED) ;
	}
	
	@PostMapping("/likes/{userId}/{tweetId}")
	public ResponseEntity<Like> likeHandler(@PathVariable int userId , @PathVariable int tweetId){
		return new ResponseEntity<>(twitterServiceImpl.likeTweet(userId, tweetId) , HttpStatus.CREATED) ;
	}
	
	@PostMapping("/retweet/{userId}/{tweetId}")
	public ResponseEntity<Retweet> retweetHandler(@PathVariable int userId , @PathVariable int tweetId){
		return new ResponseEntity<>(twitterServiceImpl.retweetTweet(userId, tweetId) , HttpStatus.CREATED) ;
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Tweet>> getAllTweetHandler(@PathVariable int userId){
		return new ResponseEntity<>(twitterServiceImpl.getAllTweet(userId), HttpStatus.OK);
	}

}
