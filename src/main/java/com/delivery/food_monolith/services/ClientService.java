package com.delivery.food_monolith.services;

import com.delivery.food_monolith.dto.ClientCreateDTO;
import com.delivery.food_monolith.dto.ClientResponseDTO;
import com.delivery.food_monolith.exceptions.DuplicateResourceException;
import com.delivery.food_monolith.mapper.ClientMapper;
import com.delivery.food_monolith.models.ClientProfile;
import com.delivery.food_monolith.models.User;
import com.delivery.food_monolith.models.enums.Role;
import com.delivery.food_monolith.repositories.ClientProfileRepository;
import com.delivery.food_monolith.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final UserRepository userRepository;
    private final ClientProfileRepository clientRepository;
    private final ClientMapper clientMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public ClientResponseDTO createUser(ClientCreateDTO dto) {

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new DuplicateResourceException("Пользователь с таким email уже зарегистрирован");
        }

        if (userRepository.existsByPhoneNumber(dto.getPhoneNumber())) {
            throw new DuplicateResourceException("Этот номер телефона уже используется");
        }

        User user = clientMapper.toUserEntity(dto);
        user.getRoles().add(Role.CLIENT);

        user.setPasswordHash(passwordEncoder.encode(dto.getPasswordHash()));

        User savedUser = userRepository.save(user);

        ClientProfile client = clientMapper.toClientProfileEntity(dto);
        client.setUser(savedUser);

        ClientProfile savedClient = clientRepository.save(client);
        return clientMapper.toDto(savedClient);
    }
}
