package com.delivery.food_monolith.controllers;

import com.delivery.food_monolith.dto.JwtResponseDTO;
import com.delivery.food_monolith.dto.LoginRequestDTO;
import com.delivery.food_monolith.services.AuthSevice;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthSevice authSevice;

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDTO> login(@RequestBody @Valid LoginRequestDTO dto) {
        JwtResponseDTO response = authSevice.login(dto);
        return ResponseEntity.ok(response);
    }
}
