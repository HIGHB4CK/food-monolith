package com.delivery.food_monolith.mapper;

import com.delivery.food_monolith.dto.MenuCategoryCreateDTO;
import com.delivery.food_monolith.dto.MenuCategoryResponseDTO;
import com.delivery.food_monolith.models.MenuCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MenuCategoryMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "restaurant", ignore = true)
    MenuCategory toEntity(MenuCategoryCreateDTO dto);

    MenuCategoryResponseDTO toDto(MenuCategory menuCategory);
}
