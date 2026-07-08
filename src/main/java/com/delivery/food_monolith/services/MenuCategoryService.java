package com.delivery.food_monolith.services;

import com.delivery.food_monolith.dto.MenuCategoryCreateDTO;
import com.delivery.food_monolith.dto.MenuCategoryResponseDTO;
import com.delivery.food_monolith.exceptions.DuplicateResourceException;
import com.delivery.food_monolith.mapper.MenuCategoryMapper;
import com.delivery.food_monolith.models.MenuCategory;
import com.delivery.food_monolith.models.Restaurant;
import com.delivery.food_monolith.repositories.MenuCategoryRepository;
import com.delivery.food_monolith.repositories.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MenuCategoryService {

    private final MenuCategoryRepository menuCategoryRepository;
    private final MenuCategoryMapper menuCategoryMapper;
    private final RestaurantRepository restaurantRepository;

    public MenuCategoryResponseDTO createMenuCategory(UUID restaurantId, MenuCategoryCreateDTO dto) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalArgumentException("Ресторан с указанным ID не найден"));

        if (menuCategoryRepository.existsByRestaurantIdAndNameIgnoreCase(restaurantId, dto.getName())) {
            throw new DuplicateResourceException("Категория " + dto.getName() + " уже существует в этом ресторане");
        }

        MenuCategory menuCategory = menuCategoryMapper.toEntity(dto);
        menuCategory.setRestaurant(restaurant);
        MenuCategory savedMenuCategory = menuCategoryRepository.save(menuCategory);

        return menuCategoryMapper.toDto(savedMenuCategory);
    }

}
