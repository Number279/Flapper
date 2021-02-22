package com.tts.review.service;

import com.tts.review.model.Greeting;

public interface GreetingService {

    //this is the contract that anyone who implements GreetingService must fulfill
    Greeting getGreeting();

}
