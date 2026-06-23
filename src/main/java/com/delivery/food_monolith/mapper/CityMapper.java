package com.delivery.food_monolith.mapper;

import com.delivery.food_monolith.dto.CityCreateDTO;
import com.delivery.food_monolith.dto.CityResponseDTO;
import com.delivery.food_monolith.models.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CityMapper {

    @Mapping(target = "id", ignore = true)
    City toEntity(CityCreateDTO dto);

    CityResponseDTO toDto(City city);
}
