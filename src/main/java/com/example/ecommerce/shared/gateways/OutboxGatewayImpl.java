package com.example.ecommerce.shared.gateways;

import com.example.ecommerce.shared.domains.Outbox;
import com.example.ecommerce.shared.domains.enums.OutboxStatus;
import com.example.ecommerce.shared.entities.OutboxEntity;
import com.example.ecommerce.shared.repositories.OutboxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OutboxGatewayImpl implements OutboxGateway {

    private final OutboxRepository outboxRepository;

    @Override
    public Outbox save(final Outbox outbox) {
        return outboxRepository.save(OutboxEntity.fromDomain(outbox))
                .toDomain();
    }

    @Transactional(readOnly = true)
    public Optional<Outbox> findByIdAndStatus(final UUID id, final OutboxStatus status) {
        return outboxRepository.findByIdAndStatus(id, status.name())
                .map(OutboxEntity::toDomain);
    }
}
