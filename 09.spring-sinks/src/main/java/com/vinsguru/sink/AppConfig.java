package com.vinsguru.sink;

import com.vinsguru.api.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Configuration
public class AppConfig {
    private static final String API_ENDPOINT = "http://localhost:8080/product";

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(API_ENDPOINT)
                .build();
    }

    @Bean
    public Sinks.Many<Product> sink() {
        return Sinks.many().replay().latest();
    }

    @Bean
    public Flux<Product> flux(Sinks.Many<Product> sink){
        return sink.asFlux();
    }
}