package com.example.ecommerce.user.controllers.dtos;

import com.example.ecommerce.user.domains.User;

import java.time.LocalDateTime;
import java.util.UUID;

public record FindUserByIdResponse(
        UUID id,
        String name,
        String status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {

    public static FindUserByIdResponse fromDomain(final User user) {
        return new FindUserByIdResponse(
                user.getId(), user.getName(), user.getStatus().name(), user.getCreatedAt(), user.getUpdatedAt());
    }
}
