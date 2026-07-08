package com.delivery.food_monolith.mapper;

import com.delivery.food_monolith.dto.FoodCreateDTO;
import com.delivery.food_monolith.dto.FoodResponseDTO;
import com.delivery.food_monolith.models.Food;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FoodMapper {

    @Mapping(target = "id", ignore = true)
    Food toEntity(FoodCreateDTO dto);

    FoodResponseDTO toDto(Food food);
}
