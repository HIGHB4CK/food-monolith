package com.delivery.food_monolith.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CityCreateDTO {
    @NotBlank(message = "Название города не может быть пустым")
    private String name;
}
