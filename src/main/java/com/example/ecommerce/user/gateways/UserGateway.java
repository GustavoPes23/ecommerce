package com.example.ecommerce.user.gateways;

import com.example.ecommerce.user.domains.User;
import com.example.ecommerce.user.domains.enums.UserStatus;

import java.util.Optional;
import java.util.UUID;

public interface UserGateway {
    User save(User user);
    Optional<User> findById(UUID id);
    Optional<User> findByIdAndStatus(UUID id, UserStatus status);
}
