package com.delivery.food_monolith.mapper;

import com.delivery.food_monolith.dto.MenuItemCreateDTO;
import com.delivery.food_monolith.dto.MenuItemResponseDTO;
import com.delivery.food_monolith.models.MenuItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MenuItemMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "menuCategory", ignore = true)
    @Mapping(target = "food", ignore = true)
    MenuItem toEntity(MenuItemCreateDTO dto);

    @Mapping(source = "food.id", target = "foodId")
    MenuItemResponseDTO toDto(MenuItem menuItem);
}
