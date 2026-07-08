package com.delivery.food_monolith.services;

import com.delivery.food_monolith.dto.StreetCreateDTO;
import com.delivery.food_monolith.dto.StreetResponseDTO;
import com.delivery.food_monolith.exceptions.DuplicateResourceException;
import com.delivery.food_monolith.mapper.StreetMapper;
import com.delivery.food_monolith.models.City;
import com.delivery.food_monolith.models.Street;
import com.delivery.food_monolith.repositories.CityRepository;
import com.delivery.food_monolith.repositories.StreetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StreetService {

    private final CityRepository cityRepository;
    private final StreetRepository streetRepository;
    private final StreetMapper streetMapper;

    @Transactional
    public StreetResponseDTO createStreet(UUID cityId, StreetCreateDTO dto) {
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new IllegalArgumentException("Город с таким ID не существует"));

        if (streetRepository.existsByCityIdAndNameIgnoreCase(cityId, dto.getName())) {
            throw new DuplicateResourceException("Улица с таким названием существует в этом городе");
        }

        Street street = streetMapper.toEntity(dto);
        street.setCity(city);

        Street savedUser = streetRepository.save(street);
        return streetMapper.toDto(savedUser);
    }

}
