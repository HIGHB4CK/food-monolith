package com.delivery.food_monolith.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class MenuCategoryResponseDTO {
    private UUID id;
    private String name;
    private Integer sortOrder;
}
