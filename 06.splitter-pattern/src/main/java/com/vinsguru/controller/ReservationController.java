package com.vinsguru.controller;

import com.vinsguru.dto.ReservationItemRequest;
import com.vinsguru.dto.ReservationResponse;
import com.vinsguru.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("splitter")
public class ReservationController {

    @Autowired
    private ReservationService service;

    @PostMapping("reserve")
    public Mono<ReservationResponse> reserve(@RequestBody Flux<ReservationItemRequest> flux){
        return this.service.reserve(flux);
    }
}