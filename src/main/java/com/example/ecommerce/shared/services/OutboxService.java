package com.example.ecommerce.shared.services;

import com.example.ecommerce.shared.domains.Outbox;
import com.example.ecommerce.shared.domains.enums.OutboxEvents;
import com.example.ecommerce.shared.domains.enums.OutboxStatus;
import com.example.ecommerce.shared.gateways.OutboxGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tools.jackson.databind.ObjectMapper;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OutboxService {

    private final ObjectMapper objectMapper;
    private final OutboxGateway outboxGateway;

    @Transactional
    public Outbox create(final Object payload, final OutboxEvents event) {
        final Outbox outbox = Outbox.create(objectMapper.writeValueAsString(payload), event);
        return outboxGateway.save(outbox);
    }

    @Transactional
    public Outbox markAsSent(final UUID id) {
        final Outbox outbox = outboxGateway.findByIdAndStatus(id, OutboxStatus.PENDING)
                .orElseThrow();

        outbox.markAsSent();

        return outboxGateway.save(outbox);
    }
}
