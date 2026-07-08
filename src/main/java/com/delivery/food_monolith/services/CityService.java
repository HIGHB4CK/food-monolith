package com.delivery.food_monolith.services;

import com.delivery.food_monolith.dto.CityCreateDTO;
import com.delivery.food_monolith.dto.CityResponseDTO;
import com.delivery.food_monolith.mapper.CityMapper;
import com.delivery.food_monolith.models.City;
import com.delivery.food_monolith.repositories.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    @Transactional
    public CityResponseDTO createCity(CityCreateDTO dto) {
        if (cityRepository.existsByNameIgnoreCase(dto.getName())) {
            throw new IllegalArgumentException("Город с таким названием уже существует");
        }

        City city = cityMapper.toEntity(dto);

        City savedCity = cityRepository.save(city);

        return cityMapper.toDto(savedCity);
    }
}
