package com.delivery.food_monolith.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(
    name = "menu_items",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"menu_category_id", "food_id"})
    }
)
@Getter
@Setter
public class MenuItem {
    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "menu_category_id")
    private MenuCategory menuCategory;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @NotBlank(message = "Укажите название блюда")
    private String name;

    private BigDecimal price;
}
