package com.example.ecommerce.shared.gateways;

import com.example.ecommerce.shared.domains.Outbox;
import com.example.ecommerce.shared.domains.enums.OutboxStatus;

import java.util.Optional;
import java.util.UUID;

public interface OutboxGateway {
    Outbox save(Outbox outbox);
    Optional<Outbox> findByIdAndStatus(UUID id, OutboxStatus status);
}
