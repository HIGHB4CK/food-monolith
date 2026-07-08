package com.delivery.food_monolith.controllers;

import com.delivery.food_monolith.dto.FoodCreateDTO;
import com.delivery.food_monolith.dto.FoodResponseDTO;
import com.delivery.food_monolith.services.FoodService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/foods")
public class FoodController {

    private final FoodService foodService;

    @PostMapping
    public ResponseEntity<FoodResponseDTO> createFood(
            @RequestBody
            @Valid
            FoodCreateDTO dto
    ) {
        FoodResponseDTO response = foodService.createFood(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
