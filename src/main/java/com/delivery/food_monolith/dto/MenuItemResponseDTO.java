package com.delivery.food_monolith.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class MenuItemResponseDTO {
    private UUID id;
    private UUID foodId;
    private String name;
    private BigDecimal price;
}
