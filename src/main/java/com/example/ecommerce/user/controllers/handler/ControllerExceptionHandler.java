package com.example.ecommerce.user.controllers.handler;

import com.example.ecommerce.user.controllers.handler.dtos.HandleResponse;
import com.example.ecommerce.user.usecases.exceptions.BusinessException;
import com.example.ecommerce.user.usecases.exceptions.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<HandleResponse> handleUserNotFound(final HttpServletRequest req, final BusinessException ex) {
        final var response = new HandleResponse(ex.getCode(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(response);
    }
}
