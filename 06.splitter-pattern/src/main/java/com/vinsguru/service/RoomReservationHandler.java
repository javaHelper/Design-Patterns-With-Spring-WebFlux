package com.vinsguru.service;

import com.vinsguru.client.RoomClient;
import com.vinsguru.dto.ReservationItemRequest;
import com.vinsguru.dto.ReservationItemResponse;
import com.vinsguru.dto.ReservationType;
import com.vinsguru.dto.RoomReservationRequest;
import com.vinsguru.dto.RoomReservationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class RoomReservationHandler extends ReservationHandler{

    @Autowired
    private RoomClient client;

    @Override
    protected ReservationType getType() {
        return ReservationType.ROOM;
    }

    @Override
    protected Flux<ReservationItemResponse> reserve(Flux<ReservationItemRequest> flux) {
        return flux.map(this::toRoomRequest)
                   .transform(this.client::reserve)
                   .map(this::toResponse);
    }

    private RoomReservationRequest toRoomRequest(ReservationItemRequest request){
        return RoomReservationRequest.create(
                request.getCity(),
                request.getFrom(),
                request.getTo(),
                request.getCategory()
        );
    }

    private ReservationItemResponse toResponse(RoomReservationResponse response){
        return ReservationItemResponse.create(
                response.getReservationId(),
                this.getType(),
                response.getCategory(),
                response.getCity(),
                response.getCheckIn(),
                response.getCheckOut(),
                response.getPrice()
        );
    }

}