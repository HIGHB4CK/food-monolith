package com.delivery.food_monolith.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class FoodCreateDTO {
    @NotBlank(message = "Укажите название")
    private String name;

    @NotNull(message = "Укажите калории")
    @Positive(message = "Калории должны быть больше нуля")
    private Integer calories;

    @NotBlank(message = "Укажите состав")
    private String composition;

    @NotBlank(message = "Добавьте описание")
    @Length(min = 10, max = 1000)
    private String description;
}
