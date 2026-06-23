package com.delivery.food_monolith.dto;

import com.delivery.food_monolith.models.Street;

import java.math.BigDecimal;
import java.util.UUID;

public class AddressResponseDTO {
    private UUID id;
    private String streetName;
    private String building;
    private String entrance;
    private Integer floor;
    private String intercom;
    private String apartment;
}
