package com.example.ecommerce.user.domains;

import com.example.ecommerce.user.domains.enums.UserStatus;
import com.github.f4b6a3.ulid.UlidCreator;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class User {
    private UUID id;
    private String name;
    private UserStatus status;

    public void create() {
        this.id = UlidCreator.getMonotonicUlid().toUuid();
        this.status = UserStatus.ACTIVE;
    }
}
