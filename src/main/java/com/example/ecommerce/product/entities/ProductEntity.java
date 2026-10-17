package com.example.ecommerce.product.entities;

import com.example.ecommerce.product.domains.Product;
import com.example.ecommerce.product.domains.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private String name;

    private String description;

    private Double price;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static ProductEntity fromDomain(final Product product) {
        return ProductEntity.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .status(product.getStatus().name())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }

    public Product toDomain() {
        return Product.builder()
                .id(id)
                .name(name)
                .description(description)
                .price(price)
                .status(ProductStatus.valueOf(status))
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}
