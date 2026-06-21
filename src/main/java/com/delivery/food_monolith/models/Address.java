package com.delivery.food_monolith.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "addresses")
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "street_id")
    private Street street;

    @NotBlank(message = "Укажите номер дома")
    @Length(max = 20)
    private String building;

    private String entrance;
    private Integer floor;
    private String intercom;
    private String apartment;

    private BigDecimal latitude;
    private BigDecimal longitude;
}
