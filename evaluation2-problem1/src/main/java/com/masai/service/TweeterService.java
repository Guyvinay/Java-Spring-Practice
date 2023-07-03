package com.masai.service;

import com.masai.model.Like;
import com.masai.model.Retweet;
import com.masai.model.Tweet;
import com.masai.model.User;

import java.util.List;

public interface TweeterService {

    public User adduser(User user);
    public Tweet addTweet(int userId , Tweet tweet);
    public Like likeTweet(int userId , int tweetId);
    public Retweet retweetTweet(int userId , int tweetId);
    public List<Tweet> getAllTweet(int userId);
}
