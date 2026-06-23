package com.delivery.food_monolith.dto;

import com.delivery.food_monolith.models.Street;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class AddressCreateDTO {

    private UUID streetId;

    @NotBlank(message = "Укажите номер дома")
    @Length(max = 20)
    private String building;

    private String entrance;
    private Integer floor;
    private String intercom;
    private String apartment;
}
