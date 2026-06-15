package com.delivery.food_monolith.repositories;

import com.delivery.food_monolith.models.ClientProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientProfileRepository extends JpaRepository<ClientProfile, Long> {

}
