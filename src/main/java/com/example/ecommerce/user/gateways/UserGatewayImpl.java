package com.example.ecommerce.user.gateways;

import com.example.ecommerce.user.domains.User;
import com.example.ecommerce.user.entities.UserEntity;
import com.example.ecommerce.user.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserGatewayImpl implements UserGateway {

    private final UserRepository userRepository;

    @Override
    public User save(final User user) {
        return userRepository.save(UserEntity.fromDomain(user))
                .toDomain();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(final UUID id) {
        return userRepository.findById(id)
                .map(UserEntity::toDomain);
    }
}
