package com.delivery.food_monolith.services;

import com.delivery.food_monolith.dto.RestaurantCreateDTO;
import com.delivery.food_monolith.dto.RestaurantResponseDTO;
import com.delivery.food_monolith.mapper.AddressMapper;
import com.delivery.food_monolith.mapper.RestaurantMapper;
import com.delivery.food_monolith.models.Address;
import com.delivery.food_monolith.models.Restaurant;
import com.delivery.food_monolith.models.Street;
import com.delivery.food_monolith.repositories.AddressRepository;
import com.delivery.food_monolith.repositories.RestaurantRepository;
import com.delivery.food_monolith.repositories.StreetRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final StreetRepository streetRepository;
    private final RestaurantRepository restaurantRepository;
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final RestaurantMapper restaurantMapper;

    @Transactional
    public RestaurantResponseDTO createRestaurant(RestaurantCreateDTO dto) {
        Street street = streetRepository.findById(dto.getAddress().getStreetId())
                .orElseThrow(() -> new IllegalArgumentException("Улица с таким ID не найдена"));


        Address address = addressMapper.toEntity(dto.getAddress());
        address.setStreet(street);
        Address savedAddress = addressRepository.save(address);

        Restaurant restaurant = restaurantMapper.toEntity(dto);
        restaurant.setAddress(savedAddress);
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);

        return restaurantMapper.toDto(savedRestaurant);
    }
}
