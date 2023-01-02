package com.vinsguru.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("card-details")
public class CardDetailController {

    @Autowired
    private CardDetailService service;


    @GetMapping()
    public Mono<ResponseEntity<CardDetails>> getProducts(){
        return this.service.getProduct()
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}