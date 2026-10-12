package com.example.ecommerce.user.gateways;

import com.example.ecommerce.user.domains.User;

public interface UserGateway {
    User save(User user);
}
