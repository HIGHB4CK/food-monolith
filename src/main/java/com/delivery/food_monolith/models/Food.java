package com.delivery.food_monolith.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Entity
@Table(name = "foods")
@Data
public class Food {
    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID id;

    @NotBlank(message = "Укажите название")
    private String name;

    @NotBlank(message = "Укажите калории")
    private Integer calories;

    @NotBlank(message = "Укажите состав")
    private String composition;

    @NotBlank(message = "Добавьте описание")
    @Length(min = 10, max = 1000)
    private String description;
}
