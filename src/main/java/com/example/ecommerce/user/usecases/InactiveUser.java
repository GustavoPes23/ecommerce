package com.example.ecommerce.user.usecases;

import com.example.ecommerce.user.domains.User;
import com.example.ecommerce.user.domains.enums.UserStatus;
import com.example.ecommerce.user.gateways.UserGateway;
import com.example.ecommerce.user.publishers.InactiveUserPublisher;
import com.example.ecommerce.user.usecases.exceptions.UserNotFoundUserException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class InactiveUser {

    private final UserGateway userGateway;
    private final InactiveUserPublisher publisher;

    @Transactional
    public void execute(final UUID id) {
        log.info("Inactive user with id=[{}]", id);

        final User user = userGateway.findByIdAndStatus(id, UserStatus.ACTIVE)
                .orElseThrow(() -> new UserNotFoundUserException(id));

        user.markAsInactive();
        userGateway.save(user);
        publisher.send(user);
    }
}
