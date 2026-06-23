package com.delivery.food_monolith.controllers;

import com.delivery.food_monolith.dto.CityCreateDTO;
import com.delivery.food_monolith.dto.CityResponseDTO;
import com.delivery.food_monolith.services.CityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @PostMapping
    public ResponseEntity<CityResponseDTO> createCity(@RequestBody @Valid CityCreateDTO dto) {
        CityResponseDTO response = cityService.createCity(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
