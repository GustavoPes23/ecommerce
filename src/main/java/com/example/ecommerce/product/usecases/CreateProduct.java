package com.example.ecommerce.product.usecases;

import com.example.ecommerce.product.domains.Product;
import com.example.ecommerce.product.gateways.ProductGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateProduct {

    private final ProductGateway productGateway;

    public Product execute(final Product product) {
        log.info("Creating product with product=[{}]", product);

        product.create();
        return productGateway.save(product);
    }
}
