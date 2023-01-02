package com.vinsguru.pubsub.producer;

import com.vinsguru.api.CardDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;

@Service
public class PublisherService {

    private static final String JOKE_API_ENDPOINT = "http://localhost:8080/card-details";
    private WebClient webClient;

    @Autowired
    private ReactiveRedisOperations<String, CardDetails> redisTemplate;

    @Value("${topic.name:card-details-channel}")
    private String topic;

    @PostConstruct
    private void init(){
        this.webClient = WebClient.builder()
                .baseUrl(JOKE_API_ENDPOINT)
                .build();
    }

    @Scheduled(fixedRate = 3000)
    public void publish(){
        this.webClient.get()
                .retrieve()
                .bodyToMono(CardDetails.class)
                .flatMap(joke -> this.redisTemplate.convertAndSend(topic, joke))
                .subscribe();
    }

}