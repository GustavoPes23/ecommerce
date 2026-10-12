package com.example.ecommerce.user.gateways;

import com.example.ecommerce.user.domains.User;
import com.example.ecommerce.user.entities.UserEntity;
import com.example.ecommerce.user.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserGatewayImpl implements UserGateway {

    private final UserRepository userRepository;

    @Override
    public User save(final User user) {
        return userRepository.save(UserEntity.fromDomain(user))
                .toDomain();
    }
}
