package com.exam.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * @EnableFeignClients
 *
 * Spring annotation that enables the detection and registration of Feign client interfaces in your application.
 * Scan for interfaces annotated with @FeignClient in the specified package(s).
 * Automatically generate runtime implementations of those interfaces.
 * Register them as Spring beans, so you can inject and use them like regular services.
 */
@SpringBootApplication
@EnableFeignClients
public class QuizServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizServiceApplication.class, args);
	}

}
