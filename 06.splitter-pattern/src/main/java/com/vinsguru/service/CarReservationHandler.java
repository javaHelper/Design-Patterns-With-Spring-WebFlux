package com.vinsguru.service;

import com.vinsguru.client.CarClient;
import com.vinsguru.dto.CarReservationRequest;
import com.vinsguru.dto.CarReservationResponse;
import com.vinsguru.dto.ReservationItemRequest;
import com.vinsguru.dto.ReservationItemResponse;
import com.vinsguru.dto.ReservationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CarReservationHandler extends ReservationHandler{

    @Autowired
    private CarClient client;

    @Override
    protected ReservationType getType() {
        return ReservationType.CAR;
    }

    @Override
    protected Flux<ReservationItemResponse> reserve(Flux<ReservationItemRequest> flux) {
        return flux.map(this::toCarRequest)
                .transform(this.client::reserve)
                .map(this::toResponse);
    }

    private CarReservationRequest toCarRequest(ReservationItemRequest request){
        return CarReservationRequest.create(
                request.getCity(),
                request.getFrom(),
                request.getTo(),
                request.getCategory()
        );
    }

    private ReservationItemResponse toResponse(CarReservationResponse response){
        return ReservationItemResponse.create(
                response.getReservationId(),
                this.getType(),
                response.getCategory(),
                response.getCity(),
                response.getPickup(),
                response.getDrop(),
                response.getPrice()
        );
    }

}