package com.example.ecommerce.product.usecases.exceptions;

public class BusinessProductException extends RuntimeException {
    private final String code;

    public BusinessProductException(final String message, final String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
