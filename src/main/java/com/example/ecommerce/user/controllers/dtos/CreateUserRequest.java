package com.example.ecommerce.user.controllers.dtos;

import com.example.ecommerce.user.domains.User;

public record CreateUserRequest(String name) {

    public User toDomain() {
        return User.builder()
                .name(name)
                .build();
    }
}
