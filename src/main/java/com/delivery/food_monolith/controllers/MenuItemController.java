package com.delivery.food_monolith.controllers;

import com.delivery.food_monolith.dto.MenuItemCreateDTO;
import com.delivery.food_monolith.dto.MenuItemResponseDTO;
import com.delivery.food_monolith.services.MenuItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/restaurants/{restaurantId}/categories/{categoryId}/items")
@RequiredArgsConstructor
public class MenuItemController {

    private final MenuItemService menuItemService;

    @PostMapping
    public ResponseEntity<MenuItemResponseDTO> createMenuItem(
            @PathVariable UUID restaurantId,
            @PathVariable UUID categoryId,
            @RequestBody @Valid MenuItemCreateDTO dto
            ) {
        MenuItemResponseDTO response = menuItemService.createMenuItem(categoryId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
