package com.vinsguru.pubsub.producer;

import com.vinsguru.api.CardDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class AppConfig {
    @Bean
    public ReactiveRedisOperations<String, CardDetails> jokeTemplate(LettuceConnectionFactory lettuceConnectionFactory){
        RedisSerializer<CardDetails> valueSerializer = new Jackson2JsonRedisSerializer<>(CardDetails.class);
        RedisSerializationContext<String, CardDetails> serializationContext =
                RedisSerializationContext.<String, CardDetails>newSerializationContext(RedisSerializer.string())
                .value(valueSerializer)
                .build();
        return new ReactiveRedisTemplate<>(lettuceConnectionFactory, serializationContext);
    }
}