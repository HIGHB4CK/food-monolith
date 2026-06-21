package com.delivery.food_monolith.controllers;

import com.delivery.food_monolith.dto.ClientCreateDTO;
import com.delivery.food_monolith.dto.ClientResponseDTO;
import com.delivery.food_monolith.services.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/register")
    public ResponseEntity<ClientResponseDTO> createUser(
            @RequestBody // Эта аннотация заставит Spring искать JSON в теле запроса
            @Valid // Активация валидации
            ClientCreateDTO dto
    ) {
        ClientResponseDTO response = clientService.createUser(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Токен работает");
    }
}
