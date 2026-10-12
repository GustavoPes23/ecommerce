package com.example.ecommerce.user.publish;

import com.example.ecommerce.shared.domains.enums.OutboxEvents;
import com.example.ecommerce.shared.services.OutboxService;
import com.example.ecommerce.user.domains.User;
import com.example.ecommerce.user.publish.dtos.UserInactiveEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InactiveUserPublisher {

    private final OutboxService outboxService;
    private final ApplicationEventPublisher publisher;

    public void send(final User user) {
        final var outbox = outboxService.create(user.getId(), OutboxEvents.USER_INACTIVE);
        publisher.publishEvent(new UserInactiveEvent(user.getId()));
        outboxService.markAsSent(outbox.getId());
    }
}
