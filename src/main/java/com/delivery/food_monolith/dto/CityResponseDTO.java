package com.delivery.food_monolith.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CityResponseDTO {
    private UUID id;
    private String name;
}
