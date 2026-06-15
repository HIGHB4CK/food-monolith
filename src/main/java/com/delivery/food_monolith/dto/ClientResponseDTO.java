package com.delivery.food_monolith.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ClientResponseDTO {
    private UUID id;
    private String name;
    private String email;
    private String phoneNumber;
    private Integer rebate;
}
