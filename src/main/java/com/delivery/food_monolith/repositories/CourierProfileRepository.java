package com.delivery.food_monolith.repositories;

import com.delivery.food_monolith.models.CourierProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierProfileRepository extends JpaRepository<CourierProfile, Long> {

}
