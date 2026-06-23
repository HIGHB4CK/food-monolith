package com.delivery.food_monolith.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StreetCreateDTO {

    @NotBlank(message = "Введите название улицы")
    private String name;
}
