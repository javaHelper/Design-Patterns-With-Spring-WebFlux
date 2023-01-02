package com.vinsguru.sink;

import com.vinsguru.api.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Sinks;

@Service
public class ProductPublisher {
    @Autowired
    private WebClient webClient;

    @Autowired
    private Sinks.Many<Product> sink;

    @Scheduled(fixedRate = 3000)
    public void publish(){
        this.webClient
                .get()
                .retrieve()
                .bodyToMono(Product.class)
                .doOnNext(e -> System.out.println("Received : "+ e))
                .subscribe(this.sink::tryEmitNext);
    }
}