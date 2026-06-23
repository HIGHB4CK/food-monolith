package com.delivery.food_monolith.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AdminResponseDTO {
    private UUID id;
    private String email;
    private String phoneNumber;
    private String surname;
    private String name;
    private String additionalName;
}
