package com.example.ecommerce.user.controllers.handler;

import com.example.ecommerce.user.controllers.handler.dtos.UserHandleResponse;
import com.example.ecommerce.user.usecases.exceptions.BusinessUserException;
import com.example.ecommerce.user.usecases.exceptions.UserNotFoundUserException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserControllerExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundUserException.class)
    public ResponseEntity<UserHandleResponse> handleUserNotFound(
            final HttpServletRequest req, final BusinessUserException ex) {
        final var response = new UserHandleResponse(ex.getCode(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(response);
    }
}
