package com.delivery.food_monolith.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class AddressResponseDTO {
    private UUID id;
    private String streetName;
    private String building;
    private String entrance;
    private Integer floor;
    private String intercom;
    private String apartment;
}
