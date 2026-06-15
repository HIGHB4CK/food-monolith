package com.delivery.food_monolith.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "client_profiles")
@Data
public class ClientProfile {
    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String name;

    @ManyToOne
    @JoinColumn(name = "default_address_id")
    private Address defaultAddress;

    private Integer rebate = 0;
}
