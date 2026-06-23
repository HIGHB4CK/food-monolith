package com.delivery.food_monolith.controllers;

import com.delivery.food_monolith.dto.StreetCreateDTO;
import com.delivery.food_monolith.dto.StreetResponseDTO;
import com.delivery.food_monolith.services.StreetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/cities/{cityId}/streets")
@RequiredArgsConstructor
public class StreetController {

    private final StreetService streetService;

    @PostMapping
    public ResponseEntity<StreetResponseDTO> createStreet(@PathVariable UUID cityId, @RequestBody @Valid StreetCreateDTO dto) {
        StreetResponseDTO response = streetService.createStreet(cityId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
