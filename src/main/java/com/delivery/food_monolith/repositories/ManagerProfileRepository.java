package com.delivery.food_monolith.repositories;

import com.delivery.food_monolith.models.ManagerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ManagerProfileRepository extends JpaRepository<ManagerProfile, UUID> {
}
