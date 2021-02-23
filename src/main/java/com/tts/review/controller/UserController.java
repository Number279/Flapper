package com.tts.review.controller;

import com.tts.review.model.Tweet;
import com.tts.review.model.User;
import com.tts.review.service.TweetService;
import com.tts.review.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TweetService tweetService;

    @GetMapping(value = "/users/{username}")
    public String getUser(@PathVariable String username, Model model){

        //find user
        User user = userService.findByUsername(username);
        //find tweets from user
        List<Tweet> tweets = tweetService.findAllByUser(user);
        User loggedInUser = userService.getLoggedInUser();
        List<User> following = loggedInUser.getFollowing();
        boolean isFollowing = false;
        for (User followedUser : following) {
            if(followedUser.getUsername().equals(username)){
                isFollowing = true;
            }
        }
        boolean isSelfPage = loggedInUser.getUsername().equals(username);
        model.addAttribute("isSelfPage", isSelfPage);
        model.addAttribute("following", isFollowing);
        model.addAttribute("user", user);
        model.addAttribute("tweetList", tweets);

        return "user";
    }

    @GetMapping(value = "/users")
    public String getUsers(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        setTweetCount(users, model);
        return "users";
    }

    private void setTweetCount(List<User> users, Model model) {
        HashMap<String, Integer> tweetCounts = new HashMap<>();
        for(User user : users){
            List<Tweet> tweets = tweetService.findAllByUser(user);
            tweetCounts.put(user.getUsername(), tweets.size());
        }
        model.addAttribute("tweetCount", tweetCounts);
    }
}
