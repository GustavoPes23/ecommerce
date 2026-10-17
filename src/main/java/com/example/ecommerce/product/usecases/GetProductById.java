package com.example.ecommerce.product.usecases;

import com.example.ecommerce.product.domains.Product;
import com.example.ecommerce.product.gateways.ProductGateway;
import com.example.ecommerce.product.usecases.exceptions.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetProductById {

    private final ProductGateway productGateway;

    public Product execute(final UUID id) {
        return productGateway.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
}
