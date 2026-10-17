package com.example.ecommerce.product.controllers.dtos;

import com.example.ecommerce.product.domains.Product;

public record CreateProductRequest(
        String name, String description, Double price, String status) {

    public Product toDomain() {
        return Product.builder()
                .name(name)
                .description(description)
                .price(price)
                .build();
    }
}
