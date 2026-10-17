package com.example.ecommerce.product.controllers.handlers;

import com.example.ecommerce.product.controllers.handlers.dtos.ProductHandleResponse;
import com.example.ecommerce.product.usecases.exceptions.ProductNotFoundException;
import com.example.ecommerce.user.controllers.handler.dtos.UserHandleResponse;
import com.example.ecommerce.user.usecases.exceptions.BusinessUserException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductControllerExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductHandleResponse> handleUserNotFound(
            final HttpServletRequest req, final BusinessUserException ex) {
        final var response = new ProductHandleResponse(ex.getCode(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(response);
    }
}
