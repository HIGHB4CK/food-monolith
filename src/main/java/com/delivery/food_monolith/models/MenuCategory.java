package com.delivery.food_monolith.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "menu_categories")
@Getter
@Setter
public class MenuCategory {
    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @NotBlank(message = "Введите название позиции")
    private String name;

    @NotBlank(message = "Укажите номер порядка")
    private Integer sortOrder;
}
