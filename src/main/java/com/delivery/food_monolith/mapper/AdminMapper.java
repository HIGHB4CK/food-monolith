package com.delivery.food_monolith.mapper;

import com.delivery.food_monolith.dto.AdminCreateDTO;
import com.delivery.food_monolith.dto.AdminResponseDTO;
import com.delivery.food_monolith.models.AdminProfile;
import com.delivery.food_monolith.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "active", constant = "true")
    User toUserEntity(AdminCreateDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    AdminProfile toAdminProfileEntity(AdminCreateDTO dto);

    @Mapping(source = "user.email", target = "email")
    @Mapping(source = "user.phoneNumber", target = "phoneNumber")
    AdminResponseDTO toDto(AdminProfile admin);
}
