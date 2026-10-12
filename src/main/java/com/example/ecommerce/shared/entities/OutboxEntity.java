package com.example.ecommerce.shared.entities;

import com.example.ecommerce.shared.domains.Outbox;
import com.example.ecommerce.shared.domains.enums.OutboxEvents;
import com.example.ecommerce.shared.domains.enums.OutboxStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Entity
@Table(name = "outbox")
@NoArgsConstructor
@AllArgsConstructor
public class OutboxEntity {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private String event;

    private String payload;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static OutboxEntity fromDomain(final Outbox outbox) {
        return OutboxEntity.builder()
                .id(outbox.getId())
                .event(outbox.getEvent().name())
                .payload(outbox.getPayload())
                .status(outbox.getStatus().name())
                .createdAt(outbox.getCreatedAt())
                .updatedAt(outbox.getUpdatedAt())
                .build();
    }

    public Outbox toDomain() {
        return Outbox.builder()
                .id(id)
                .event(OutboxEvents.valueOf(event))
                .payload(payload)
                .status(OutboxStatus.valueOf(status))
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}
