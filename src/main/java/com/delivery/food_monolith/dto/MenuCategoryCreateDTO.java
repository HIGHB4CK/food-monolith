package com.delivery.food_monolith.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MenuCategoryCreateDTO {
    @NotBlank(message = "Введите название позиции")
    private String name;

    @NotNull(message = "Укажите номер порядка")
    private Integer sortOrder;
}
