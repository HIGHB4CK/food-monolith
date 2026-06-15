package com.delivery.food_monolith.mapper;

import com.delivery.food_monolith.dto.ClientCreateDTO;
import com.delivery.food_monolith.dto.ClientResponseDTO;
import com.delivery.food_monolith.models.ClientProfile;
import com.delivery.food_monolith.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "active", constant = "true")
    User toUserEntity(ClientCreateDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "defaultAddress", ignore = true)
    ClientProfile toClientProfileEntity(ClientCreateDTO dto);

    @Mapping(source = "user.email", target = "email")
    @Mapping(source = "user.phoneNumber", target = "phoneNumber")
    ClientResponseDTO toDto(ClientProfile client);
}
