package com.delivery.food_monolith.services;

import com.delivery.food_monolith.dto.MenuItemCreateDTO;
import com.delivery.food_monolith.dto.MenuItemResponseDTO;
import com.delivery.food_monolith.exceptions.DuplicateResourceException;
import com.delivery.food_monolith.mapper.MenuItemMapper;
import com.delivery.food_monolith.models.Food;
import com.delivery.food_monolith.models.MenuCategory;
import com.delivery.food_monolith.models.MenuItem;
import com.delivery.food_monolith.repositories.FoodRepository;
import com.delivery.food_monolith.repositories.MenuCategoryRepository;
import com.delivery.food_monolith.repositories.MenuItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MenuItemService {
    private final MenuCategoryRepository menuCategoryRepository;
    private final FoodRepository foodRepository;
    private final MenuItemRepository menuItemRepository;
    private final MenuItemMapper menuItemMapper;

    @Transactional
    public MenuItemResponseDTO createMenuItem(UUID categoryId, MenuItemCreateDTO dto) {
        MenuCategory menuCategory = menuCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Категория не найдена"));

        Food food = foodRepository.findById(dto.getFoodId())
                .orElseThrow(() -> new IllegalArgumentException("Блюдо не найдено"));

        if (menuItemRepository.existsByMenuCategoryIdAndNameIgnoreCase(categoryId, dto.getName())) {
            throw new DuplicateResourceException("Блюдо " + dto.getName() + " уже есть в этой категории");
        }

        MenuItem menuItem = menuItemMapper.toEntity(dto);
        menuItem.setMenuCategory(menuCategory);
        menuItem.setFood(food);
        MenuItem savedMenuItem = menuItemRepository.save(menuItem);

        return menuItemMapper.toDto(savedMenuItem);
    }
}
