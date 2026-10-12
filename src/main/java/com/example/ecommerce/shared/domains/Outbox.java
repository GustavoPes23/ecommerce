package com.example.ecommerce.shared.domains;

import com.example.ecommerce.shared.domains.enums.OutboxEvents;
import com.example.ecommerce.shared.domains.enums.OutboxStatus;
import com.github.f4b6a3.ulid.UlidCreator;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
public class Outbox {
    private UUID id;
    private OutboxEvents event;
    private OutboxStatus status;
    private String payload;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static Outbox create(final String payload, final OutboxEvents event) {
        return Outbox.builder()
                .id(UlidCreator.getMonotonicUlid().toUuid())
                .payload(payload)
                .event(event)
                .status(OutboxStatus.PENDING)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public void markAsSent() {
        this.status = OutboxStatus.SENT;
        this.updatedAt = LocalDateTime.now();
    }
}
