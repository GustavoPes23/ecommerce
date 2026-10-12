package com.example.ecommerce.user.gateways;

import com.example.ecommerce.user.domains.User;

import java.util.Optional;
import java.util.UUID;

public interface UserGateway {
    User save(User user);
    Optional<User> findById(UUID id);
}
