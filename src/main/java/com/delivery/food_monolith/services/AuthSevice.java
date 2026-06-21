package com.delivery.food_monolith.services;

import com.delivery.food_monolith.dto.JwtResponseDTO;
import com.delivery.food_monolith.dto.LoginRequestDTO;
import com.delivery.food_monolith.models.User;
import com.delivery.food_monolith.repositories.UserRepository;
import com.delivery.food_monolith.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthSevice {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public JwtResponseDTO login(LoginRequestDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new BadCredentialsException("Неверный email или пароль"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPasswordHash())) {
            throw new BadCredentialsException("Неверный email или пароль");
        }

        String token = jwtService.generateToken(user);

        return new JwtResponseDTO(token);
    }
}
