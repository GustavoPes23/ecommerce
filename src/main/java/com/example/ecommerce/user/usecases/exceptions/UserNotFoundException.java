package com.example.ecommerce.user.usecases.exceptions;

import java.util.UUID;

public class UserNotFoundException extends BusinessException {

    private static final String CODE = "user_not_found";
    private static final String MSG = "Not found user with id=[%s]";

    public UserNotFoundException(final UUID id) {
        super(String.format(MSG, id), CODE);
    }
}
