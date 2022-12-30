package com.vinsguru.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FlightResult {
    private String airline;
    private String from;
    private String to;
    private Double price;
    private LocalDate date;
}