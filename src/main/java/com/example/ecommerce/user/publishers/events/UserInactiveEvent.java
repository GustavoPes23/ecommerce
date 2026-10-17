package com.example.ecommerce.user.publishers.events;

import com.example.ecommerce.shared.domains.Event;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
public class UserInactiveEvent extends Event {
    private UUID userId;
}
