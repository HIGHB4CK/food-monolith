package com.delivery.food_monolith.services;

import com.delivery.food_monolith.dto.AdminCreateDTO;
import com.delivery.food_monolith.dto.AdminResponseDTO;
import com.delivery.food_monolith.exceptions.DuplicateResourceException;
import com.delivery.food_monolith.mapper.AdminMapper;
import com.delivery.food_monolith.models.AdminProfile;
import com.delivery.food_monolith.models.User;
import com.delivery.food_monolith.models.enums.Role;
import com.delivery.food_monolith.repositories.AdminProfileRepository;
import com.delivery.food_monolith.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;
    private final AdminProfileRepository adminProfileRepository;
    private final AdminMapper adminMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public AdminResponseDTO registerAdmin(AdminCreateDTO dto) {

        if (userRepository.existsByEmailIgnoreCase(dto.getEmail())) {
            throw new DuplicateResourceException("Администратор с такой эл. почтой существует");
        }

        if (userRepository.existsByPhoneNumber(dto.getPhoneNumber())) {
            throw new DuplicateResourceException("Администратор с таким номером телефона существует");
        }

        User user = adminMapper.toUserEntity(dto);
        user.getRoles().add(Role.ADMIN);
        user.setPasswordHash(passwordEncoder.encode(dto.getPassword()));

        User savedUser = userRepository.save(user);

        AdminProfile admin = adminMapper.toAdminProfileEntity(dto);
        admin.setUser(savedUser);

        AdminProfile savedAdmin = adminProfileRepository.save(admin);

        return adminMapper.toDto(savedAdmin);
    }
}
