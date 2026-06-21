package com.delivery.food_monolith.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequestDTO {
    @NotBlank(message = "Введите email")
    private String email;

    @NotBlank(message = "Введите пароль")
    private String password;
}
