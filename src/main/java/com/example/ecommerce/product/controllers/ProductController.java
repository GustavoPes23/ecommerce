package com.example.ecommerce.product.controllers;

import com.example.ecommerce.product.controllers.dtos.CreateProductRequest;
import com.example.ecommerce.product.controllers.dtos.CreateProductResponse;
import com.example.ecommerce.product.controllers.dtos.GetProductByIdResponse;
import com.example.ecommerce.product.domains.Product;
import com.example.ecommerce.product.usecases.CreateProduct;
import com.example.ecommerce.product.usecases.GetProductById;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final CreateProduct createProduct;
    private final GetProductById getProductById;

    @PostMapping
    public ResponseEntity<CreateProductResponse> create(
            final @RequestBody CreateProductRequest request) {
        final Product product = createProduct.execute(request.toDomain());
        return ResponseEntity.status(HttpStatus.CREATED).body(CreateProductResponse.fromDomain(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetProductByIdResponse> getById(final @PathVariable("id") UUID id) {
        final Product product = getProductById.execute(id);
        return ResponseEntity.ok().body(GetProductByIdResponse.fromDomain(product));
    }
}
