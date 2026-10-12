package com.example.ecommerce.user.controllers.dtos;

import com.example.ecommerce.user.domains.User;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateUserResponse(UUID id, String name, String status, LocalDateTime createdAt) {

    public static CreateUserResponse fromDomain(final User user) {
        return new CreateUserResponse(
                user.getId(), user.getName(), user.getStatus().name(), user.getCreatedAt());
    }
}
