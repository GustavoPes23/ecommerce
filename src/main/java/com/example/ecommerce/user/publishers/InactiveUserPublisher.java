package com.example.ecommerce.user.publishers;

import com.example.ecommerce.shared.domains.enums.OutboxEvents;
import com.example.ecommerce.shared.services.OutboxService;
import com.example.ecommerce.user.domains.User;
import com.example.ecommerce.user.publishers.events.UserInactiveEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InactiveUserPublisher {

    private final OutboxService outboxService;

    public void send(final User user) {
        final var event = new UserInactiveEvent(user.getId());
        final var outbox = outboxService.create(event, OutboxEvents.USER_INACTIVE);
        outboxService.send(outbox.getId(), event);
    }
}
