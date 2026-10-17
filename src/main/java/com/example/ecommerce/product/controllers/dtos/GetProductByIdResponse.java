package com.example.ecommerce.product.controllers.dtos;

import com.example.ecommerce.product.domains.Product;

import java.time.LocalDateTime;
import java.util.UUID;

public record GetProductByIdResponse(
        UUID id,
        String name,
        String description,
        Double price,
        String status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {

    public static GetProductByIdResponse fromDomain(final Product product) {
        return new GetProductByIdResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStatus().name(),
                product.getCreatedAt(),
                product.getUpdatedAt()
        );
    }
}
