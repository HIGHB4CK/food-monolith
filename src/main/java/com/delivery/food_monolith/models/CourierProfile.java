package com.delivery.food_monolith.models;

import com.delivery.food_monolith.models.enums.Vehicle;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "courier_profiles")
@Data
public class CourierProfile {
    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String surname;

    private String name;

    private String additionalName;

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(name = "vehicle_type", nullable = false)
    private Vehicle vehicleType;

    private String passportNum;

}
