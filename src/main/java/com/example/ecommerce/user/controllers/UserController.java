package com.example.ecommerce.user.controllers;

import com.example.ecommerce.user.controllers.dtos.CreateUserRequest;
import com.example.ecommerce.user.controllers.dtos.CreateUserResponse;
import com.example.ecommerce.user.domains.User;
import com.example.ecommerce.user.usecases.CreateUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final CreateUser createUser;

    @PostMapping
    public ResponseEntity<CreateUserResponse> create(final @RequestBody CreateUserRequest request) {
        final User user = createUser.execute(request.toDomain());
        return ResponseEntity.status(HttpStatus.CREATED).body(CreateUserResponse.fromDomain(user));
    }
}
