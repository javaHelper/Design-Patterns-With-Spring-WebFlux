package com.vinsguru.api;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CardDetails {
    private Integer id;
    private String creditCardNumber;
    private String cardType;
    private String creditCardExpiry;
}