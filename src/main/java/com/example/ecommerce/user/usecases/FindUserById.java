package com.example.ecommerce.user.usecases;

import com.example.ecommerce.user.domains.User;
import com.example.ecommerce.user.gateways.UserGateway;
import com.example.ecommerce.user.usecases.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindUserById {

    private final UserGateway userGateway;

    public User execute(final UUID id) {
        return userGateway.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}
