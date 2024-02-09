package com.masai.repository;

import com.masai.exception.TweeterException;
import com.masai.model.Like;
import com.masai.model.Retweet;
import com.masai.model.Tweet;
import com.masai.model.User;

import java.util.List;

public interface TweeterRepository {

    public User adduser(User user) throws TweeterException;
    public Tweet addTweet(int userId , Tweet tweet) throws TweeterException;
    public Like likeTweet(int userId , int tweetId) throws TweeterException;
    public Retweet retweetTweet(int userId , int tweetId) throws TweeterException;
    public List<Tweet> getAllTweet(int userId) throws TweeterException;
}
