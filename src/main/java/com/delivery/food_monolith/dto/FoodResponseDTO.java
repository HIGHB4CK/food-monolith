package com.delivery.food_monolith.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class FoodResponseDTO {
    private UUID id;
    private String name;
    private Integer calories;
    private String composition;
    private String description;
}
