package com.exam.quiz.service;

import com.exam.quiz.entity.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Handles service communication using service names instead of fixed URLs.
 * Since multiple instances of the same service may run on different URLs,
 * using a service name allows a load balancer to distribute traffic
 * dynamically across those instances.
 *
 * This enables load balancing and improves fault tolerance and scalability.
 * Instead of hardcoding service URLs, we refer to them by name (e.g., via Eureka),
 * allowing the load balancer to choose an available instance.
 *
 */
//@FeignClient(url = "http://localhost:8082", value = "Client")
@FeignClient(name = "QUESTION-SERVICE")
public interface QuestionClient {

    @GetMapping("/api/v1/questions/quiz/{quizId}")
    List<Question> getQuestionOfQuiz(@PathVariable Long quizId);
}
