package com.vinsguru.service;

import com.vinsguru.dto.ReservationItemRequest;
import com.vinsguru.dto.ReservationItemResponse;
import com.vinsguru.dto.ReservationType;
import reactor.core.publisher.Flux;

public abstract class ReservationHandler {

    protected abstract ReservationType getType();
    protected abstract Flux<ReservationItemResponse> reserve(Flux<ReservationItemRequest> flux);

}