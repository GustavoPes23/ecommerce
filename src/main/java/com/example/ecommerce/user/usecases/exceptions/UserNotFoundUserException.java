package com.example.ecommerce.user.usecases.exceptions;

import java.util.UUID;

public class UserNotFoundUserException extends BusinessUserException {

    private static final String CODE = "user_not_found";
    private static final String MSG = "Not found user with id=[%s]";

    public UserNotFoundUserException(final UUID id) {
        super(String.format(MSG, id), CODE);
    }
}
