package com.vinsguru.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CardDetailService {

    @Autowired
    private DataGenerator dataGenerator;

    public Mono<CardDetails> getProduct(){
        return Mono.just(dataGenerator.findCardDetail());
    }
}