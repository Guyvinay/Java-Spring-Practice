package com.masai.repository;

import com.masai.exception.TweeterException;
import com.masai.model.Like;
import com.masai.model.Retweet;
import com.masai.model.Tweet;
import com.masai.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TwitterRepositoryImpl implements TweeterRepository{


    private Map<Integer, User> userList;
    private Map<Integer, Tweet> tweetList;
    private Map<Integer, Like> likeList;
    private Map<Integer, Retweet> retweetList;


    @PostConstruct
    public void postConstruct() {

        Map<Integer , User> userMap = new HashMap<>();
        Map<Integer, Tweet> tweetMap =  new HashMap<>();
        Map<Integer, Like> likeMap = new HashMap<>();
        Map<Integer, Retweet> retweetMap = new HashMap<>();

        userMap.put(1, new User(1, "Zakir", "zakir@gmail.com")) ;
        userMap.put(2, new User(2, "Shakir", "shakir@gmail.com")) ;
        userMap.put(3, new User(3, "Sayeed", "sayeed@gmail.com")) ;

        tweetMap.put(1, new Tweet(1, 1, "Hello World")) ;
        tweetMap.put(2, new Tweet(2, 2, "First Tweet")) ;
        tweetMap.put(3, new Tweet(3, 1, "Coding started")) ;

        likeMap.put(1, new Like(1, 2, 1) ) ;
        tweetMap.get(1).getLikeList().add(2) ;
        likeMap.put(2, new Like(2, 3, 1) ) ;
        tweetMap.get(1).getLikeList().add(3) ;
        likeMap.put(3, new Like(3, 1, 2) ) ;
        tweetMap.get(2).getLikeList().add(1) ;

        retweetMap.put(1, new Retweet(1, 2, 1)) ;
        tweetMap.get(1).getRetweetList().add(2);
        retweetMap.put(2, new Retweet(2, 2, 3)) ;
        tweetMap.get(3).getRetweetList().add(2);

        userList = userMap ;
        tweetList =  tweetMap;
        likeList = likeMap ;
        retweetList = retweetMap;


    }

    @Override
    public User adduser(User user) {
        if(user == null) throw new TweeterException("null value") ;
        int userId = userList.keySet().stream().max((a1, a2) -> a1-a2).get()+1 ;
        user.setUserId(userId);
        userList.put(user.getUserId(), user) ;
        return user ;
    }

    @Override
    public Tweet addTweet(int userId , Tweet tweet) {
        if(tweet == null) throw new TweeterException("null value") ;
        if(userList.get(userId) == null) throw new TweeterException("null value") ;
        int tweetId = tweetList.keySet().stream().max((a1, a2) -> a1-a2).get()+1 ;
        tweet.setTweetId(tweetId);
        tweet.setUserId(userId);
        userList.get(userId).getTweetList().add(tweet.getTweetId()) ;
        tweetList.put(tweetId, tweet) ;
        return tweet ;
    }

    @Override
    public Like likeTweet(int userId , int tweetId) {
        User user = userList.get(userId) ;
        Tweet tweet = tweetList.get(tweetId);
        if(user == null || tweet == null) throw new TweeterException("null value") ;
        int likeId = likeList.keySet().stream().max((a1, a2) -> a1-a2).get()+1 ;
        Like like = new Like(likeId, userId, tweetId) ;
        tweet.getLikeList().add(likeId) ;
        likeList.put(likeId, like) ;
        return like;
    }

    @Override
    public Retweet retweetTweet(int userId , int tweetId) {
        User user = userList.get(userId) ;
        Tweet tweet = tweetList.get(tweetId);
        if(user == null || tweet == null) throw new TweeterException("null value") ;
        int retweetId = retweetList.keySet().stream().max((a1, a2) -> a1-a2).get()+1 ;
        Retweet retweet = new Retweet(retweetId, userId, tweetId) ;
        tweet.getRetweetList().add(retweetId) ;
        retweetList.put(retweetId, retweet);
        return retweet;
    }

    @Override
    public List<Tweet> getAllTweet(int userId){
        List<Tweet> tweets = tweetList.values().stream().filter((a) -> a.getUserId() == userId).toList() ;
        return tweets;
    }


}
