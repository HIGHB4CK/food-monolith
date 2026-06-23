package com.delivery.food_monolith.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class RestaurantResponseDTO {
    private UUID id;
    private String name;
    private AddressResponseDTO address;
}
