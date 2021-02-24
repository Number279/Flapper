package com.tts.review.service;

import com.tts.review.model.Tweet;
import com.tts.review.model.TweetDisplay;
import com.tts.review.model.User;

import java.util.List;
import java.util.Optional;

public interface TweetService {
    List<TweetDisplay> findAll();
    List<TweetDisplay> findAllByUser(User user);
    List<TweetDisplay> findAllByUsers(List<User> users);
    List<TweetDisplay> findAllWithTag(String tag);
    List<TweetDisplay> formatTweets(List<Tweet> tweets);
    void save(Tweet tweet);
    void handleTags(Tweet tweet);
    void addTagLinks(List<Tweet> tweets);
    void shortenLinks(List<Tweet> tweets);
    Optional<Tweet> findById(Long id);
    List<TweetDisplay> formatTimestamps(List<Tweet> tweets);

}
