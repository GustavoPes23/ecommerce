package com.example.ecommerce.user.usecases.exceptions;

public class BusinessException extends RuntimeException {

    private final String code;

    public BusinessException(final String message, final String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
