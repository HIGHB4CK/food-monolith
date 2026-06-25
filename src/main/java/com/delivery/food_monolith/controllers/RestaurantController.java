package com.delivery.food_monolith.controllers;

import com.delivery.food_monolith.dto.RestaurantCreateDTO;
import com.delivery.food_monolith.dto.RestaurantResponseDTO;
import com.delivery.food_monolith.services.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<RestaurantResponseDTO> createRestaurant(
            @RequestBody
            @Valid
            RestaurantCreateDTO dto
    ) {
        RestaurantResponseDTO response = restaurantService.createRestaurant(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
