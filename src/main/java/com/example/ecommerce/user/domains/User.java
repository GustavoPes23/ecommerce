package com.example.ecommerce.user.domains;

import com.example.ecommerce.user.domains.enums.UserStatus;
import com.github.f4b6a3.ulid.UlidCreator;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
public class User {
    private UUID id;
    private String name;
    private UserStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public void create() {
        this.id = UlidCreator.getMonotonicUlid().toUuid();
        this.status = UserStatus.ACTIVE;
        this.createdAt = LocalDateTime.now();
    }

    public void markAsInactive() {
        this.status = UserStatus.INACTIVE;
        this.updatedAt = LocalDateTime.now();
    }
}
