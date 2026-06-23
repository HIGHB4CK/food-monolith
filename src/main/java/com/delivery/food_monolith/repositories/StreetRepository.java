package com.delivery.food_monolith.repositories;

import com.delivery.food_monolith.models.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StreetRepository extends JpaRepository<Street, UUID> {

    boolean existsByCityIdAndName(UUID cityId, String name);
}
