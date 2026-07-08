package com.delivery.food_monolith.services;

import com.delivery.food_monolith.dto.FoodCreateDTO;
import com.delivery.food_monolith.dto.FoodResponseDTO;
import com.delivery.food_monolith.exceptions.DuplicateResourceException;
import com.delivery.food_monolith.mapper.FoodMapper;
import com.delivery.food_monolith.models.Food;
import com.delivery.food_monolith.repositories.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;
    private final FoodMapper foodMapper;

    @Transactional
    public FoodResponseDTO createFood(FoodCreateDTO dto) {
        if (foodRepository.existsByNameIgnoreCase(dto.getName())) {
            throw new DuplicateResourceException("Блюдо с таким названием уже существует");
        }

        Food food = foodMapper.toEntity(dto);
        Food savedFood = foodRepository.save(food);

        return foodMapper.toDto(savedFood);
    }
}
