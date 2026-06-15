package com.delivery.food_monolith.models;

import com.delivery.food_monolith.models.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;
import org.hibernate.validator.constraints.Length;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@SQLDelete(sql = "UPDATE users SET is_active = false WHERE id = ?") // Переопределене команды удаления(repo.delete сделает UPDATE
@SQLRestriction("is_active = true") // Фильтр для SELECT
public class User {
    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID id;

    @NotBlank(message = "Введите электронную почту")
    @Pattern(
            regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
            message = "Неверный формат почты"
    )
    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "is_active", nullable = false)
    private boolean active = true;

    @NotBlank(message = "Номер телефона не может быть пустым")
    @Pattern(
            regexp = "^\\+7\\d{10}$",
            message = "Номер должен начинаться с +7 и содержать ровно 11 цифр"
    )
    private String phoneNumber;

    @NotBlank(message = "Придумайте пароль")
    @Length(min = 8, message = "Пароль должен содержать минимум 8 символов")
    private String passwordHash;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    private Set<Role> roles = new HashSet<>();
}
