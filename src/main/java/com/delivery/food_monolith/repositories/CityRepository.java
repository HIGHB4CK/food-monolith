package com.delivery.food_monolith.repositories;

import com.delivery.food_monolith.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CityRepository extends JpaRepository<City, UUID> {

    boolean existsByName(String name);
}
