package com.example.ecommerce.user.usecases.exceptions;

public class BusinessUserException extends RuntimeException {

    private final String code;

    public BusinessUserException(final String message, final String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
