package com.example.ecommerce.product.domains;

import com.example.ecommerce.product.domains.enums.ProductStatus;
import com.github.f4b6a3.ulid.UlidCreator;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
public class Product {
    private UUID id;
    private String name;
    private String description;
    private Double price;
    private ProductStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public void create() {
        this.id = UlidCreator.getMonotonicUlid().toUuid();
        this.status = ProductStatus.ACTIVE;
        this.createdAt = LocalDateTime.now();
    }
}
