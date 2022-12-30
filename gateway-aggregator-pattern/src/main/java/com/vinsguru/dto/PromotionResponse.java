package com.vinsguru.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
@Data
public class PromotionResponse {
    private Integer id;
    private String type;
    private Double discount;
    private LocalDate endDate;
}