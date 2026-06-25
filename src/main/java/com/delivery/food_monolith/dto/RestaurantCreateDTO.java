package com.delivery.food_monolith.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RestaurantCreateDTO {
    @NotBlank(message = "Введите название ресторана")
    private String name;

    @Valid
    @NotNull(message = "Укажите адрес ресторана")
    private AddressCreateDTO address;
}
