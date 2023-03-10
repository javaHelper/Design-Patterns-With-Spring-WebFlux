package com.vinsguru.pubsub.consumer;

import com.vinsguru.api.CardDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.ReactiveSubscription;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class SubscriberService {

    @Autowired
    private ReactiveRedisOperations<String, CardDetails> reactiveRedisTemplate;

    @Value("${topic.name:card-details-channel}")
    private String topic;

    @PostConstruct
    private void init(){
        this.reactiveRedisTemplate
                .listenTo(ChannelTopic.of(topic))
                .map(ReactiveSubscription.Message::getMessage)
                .subscribe(System.out::println);
    }
}