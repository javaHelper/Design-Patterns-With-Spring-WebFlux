package com.vinsguru.webfluxsse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringWebfluxStreamingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebfluxStreamingApplication.class, args);
	}

}