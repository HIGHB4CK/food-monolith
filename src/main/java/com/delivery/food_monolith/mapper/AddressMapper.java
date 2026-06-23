package com.delivery.food_monolith.mapper;

import com.delivery.food_monolith.dto.AddressCreateDTO;
import com.delivery.food_monolith.dto.AddressResponseDTO;
import com.delivery.food_monolith.models.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "street", ignore = true)
    @Mapping(target = "latitude", ignore = true)
    @Mapping(target = "longitude", ignore = true)
    Address toEntity(AddressCreateDTO dto);

    @Mapping(source = "street.name", target = "streetName")
    AddressResponseDTO toDto(Address address);
}
