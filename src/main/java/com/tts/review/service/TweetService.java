package com.tts.review.service;

import com.tts.review.model.Tweet;
import com.tts.review.model.User;

import java.util.List;
import java.util.Optional;

public interface TweetService {
    List<Tweet> findAll();
    List<Tweet> findAllByUser(User user);
    List<Tweet> findAllByUsers(List<User> users);
    List<Tweet> findAllWithTag(String tag);
    List<Tweet> formatTweets(List<Tweet> tweets);
    void save(Tweet tweet);
    void handleTags(Tweet tweet);
    void addTagLinks(List<Tweet> tweets);
    void shortenLinks(List<Tweet> tweets);
    Optional<Tweet> findById(Long id);

}
