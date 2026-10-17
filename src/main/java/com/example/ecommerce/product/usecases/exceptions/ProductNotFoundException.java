package com.example.ecommerce.product.usecases.exceptions;

import java.util.UUID;

public class ProductNotFoundException extends BusinessProductException {
    private static final String CODE = "product_not_found";
    private static final String MSG = "Not found product with id=[%s]";

    public ProductNotFoundException(final UUID id) {
        super(String.format(MSG, id), CODE);
    }
}
