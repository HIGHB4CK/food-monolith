package com.delivery.food_monolith.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class MenuItemCreateDTO {
    @NotNull(message = "Укажите блюдо")
    private UUID foodId;

    @NotBlank(message = "Введите название позиции")
    private String name;

    @NotNull(message = "Укажите стоимость позиции")
    @Positive(message = "Стоимость должна быть положительной")
    private BigDecimal price;
}
