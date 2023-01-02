package com.vinsguru.webfluxsse.config;

import com.vinsguru.webfluxsse.producer.Joke;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Configuration
public class AppConfig {
    private static final String JOKE_API_ENDPOINT = "https://joke.deno.dev/";

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(JOKE_API_ENDPOINT)
                .build();
    }

    /**
     * A Sinks.Many with the following characteristics:
     * Multicast
     * Without Subscriber: the latest element pushed to this sink are remembered, even when there is no subscriber.
     * Older elements are discarded
     * Backpressure : this sink honors downstream demand of individual subscribers.
     * Replaying: the latest element pushed to this sink is replayed to new subscribers.
     * @return
     */
    @Bean
    public Sinks.Many<Joke> sink() {
        return Sinks.many().replay().latest();
    }

    /**
     * Turn this Flux into a hot source and cache last emitted signals for further Subscriber.
     * Will retain an unbounded volume of onNext signals. Completion and Error will also be replayed
     * @param sink
     * @return
     */
    @Bean
    public Flux<Joke> flux(Sinks.Many<Joke> sink){
        return sink.asFlux().cache();
    }
}