package com.vinsguru.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
public class CarReservationRequest {
    private String city;
    private LocalDate pickup;
    private LocalDate drop;
    private String category;
}