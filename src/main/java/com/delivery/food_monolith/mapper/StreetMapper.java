package com.delivery.food_monolith.mapper;

import com.delivery.food_monolith.dto.StreetCreateDTO;
import com.delivery.food_monolith.dto.StreetResponseDTO;
import com.delivery.food_monolith.models.Street;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StreetMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "city", ignore = true)
    Street toEntity(StreetCreateDTO dto);

    StreetResponseDTO toDto(Street street);
}
