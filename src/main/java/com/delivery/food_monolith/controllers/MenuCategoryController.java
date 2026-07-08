package com.delivery.food_monolith.controllers;

import com.delivery.food_monolith.dto.MenuCategoryCreateDTO;
import com.delivery.food_monolith.dto.MenuCategoryResponseDTO;
import com.delivery.food_monolith.services.MenuCategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurants/{restaurantId}/categories")
public class MenuCategoryController {

    private final MenuCategoryService menuCategoryService;

    @PostMapping
    public ResponseEntity<MenuCategoryResponseDTO> createMenuCategory(
            @PathVariable UUID restaurantId,
            @RequestBody @Valid MenuCategoryCreateDTO dto
    ) {
        MenuCategoryResponseDTO response = menuCategoryService.createMenuCategory(restaurantId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
