package com.example.ecommerce.product.gateways;

import com.example.ecommerce.product.domains.Product;

import java.util.Optional;
import java.util.UUID;

public interface ProductGateway {
    Product save(Product product);
    Optional<Product> findById(UUID id);
}
