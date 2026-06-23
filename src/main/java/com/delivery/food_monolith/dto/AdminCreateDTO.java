package com.delivery.food_monolith.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class AdminCreateDTO {

    @NotBlank(message = "Введите электронную почту")
    @Pattern(
            regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
            message = "Неверный формат почты"
    )
    private String email;

    @NotBlank(message = "Номер телефона не может быть пустым")
    @Pattern(
            regexp = "^\\+7\\d{10}$",
            message = "Номер должен начинаться с +7 и содержать ровно 11 цифр"
    )
    private String phoneNumber;

    @NotBlank(message = "Придумайте пароль")
    @Length(min = 8, message = "Пароль должен содержать минимум 8 символов")
    private String password;

    @NotBlank(message = "Фамилия не может быть пустым")
    private String surname;

    @NotBlank(message = "Имя не может быть пустым")
    private String name;

    private String additionalName;

}
