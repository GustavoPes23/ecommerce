package com.example.ecommerce.user.entities;

import com.example.ecommerce.user.domains.User;
import com.example.ecommerce.user.domains.enums.UserStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private String name;

    private String status;

    public static UserEntity fromDomain(final User user) {
        return UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .status(user.getStatus().name())
                .build();
    }

    public User toDomain() {
        return User.builder()
                .id(id)
                .name(name)
                .status(UserStatus.valueOf(status))
                .build();
    }
}
