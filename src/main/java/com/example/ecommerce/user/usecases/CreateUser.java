package com.example.ecommerce.user.usecases;

import com.example.ecommerce.user.domains.User;
import com.example.ecommerce.user.gateways.UserGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateUser {

    private final UserGateway userGateway;

    @Transactional
    public User execute(final User user) {
        log.info("Creating User with name=[{}]", user.getName());

        user.create();

        return userGateway.save(user);
    }
}
