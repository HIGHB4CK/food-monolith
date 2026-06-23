package com.delivery.food_monolith.controllers;

import com.delivery.food_monolith.dto.AdminCreateDTO;
import com.delivery.food_monolith.dto.AdminResponseDTO;
import com.delivery.food_monolith.services.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admins")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<AdminResponseDTO> registerAdmin(@RequestBody @Valid AdminCreateDTO dto) {
        AdminResponseDTO response = adminService.registerAdmin(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
