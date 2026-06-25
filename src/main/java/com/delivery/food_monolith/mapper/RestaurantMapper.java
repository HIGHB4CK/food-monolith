package com.delivery.food_monolith.mapper;

import com.delivery.food_monolith.dto.RestaurantCreateDTO;
import com.delivery.food_monolith.dto.RestaurantResponseDTO;
import com.delivery.food_monolith.models.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface RestaurantMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    Restaurant toEntity(RestaurantCreateDTO dto);

    RestaurantResponseDTO toDto(Restaurant restaurant);
}
