package com.delivery.food_monolith.repositories;

import com.delivery.food_monolith.models.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MenuCategoryRepository extends JpaRepository<MenuCategory, UUID> {
    boolean existsByRestaurantIdAndNameIgnoreCase(UUID restaurantId, String name);
}
