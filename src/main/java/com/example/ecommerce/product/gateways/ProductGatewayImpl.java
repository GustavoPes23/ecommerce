package com.example.ecommerce.product.gateways;

import com.example.ecommerce.product.domains.Product;
import com.example.ecommerce.product.entities.ProductEntity;
import com.example.ecommerce.product.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProductGatewayImpl implements ProductGateway {

    private final ProductRepository productRepository;

    @Override
    public Product save(final Product product) {
        return productRepository.save(ProductEntity.fromDomain(product))
                .toDomain();
    }

    @Override
    public Optional<Product> findById(final UUID id) {
        return productRepository.findById(id)
                .map(ProductEntity::toDomain);
    }
}
