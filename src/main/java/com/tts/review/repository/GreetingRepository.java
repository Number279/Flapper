package com.tts.review.repository;

import com.tts.review.model.Greeting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends CrudRepository<Greeting, Long> {
}
