package com.example.ecommerce.user.controllers;

import com.example.ecommerce.user.controllers.dtos.CreateUserRequest;
import com.example.ecommerce.user.controllers.dtos.CreateUserResponse;
import com.example.ecommerce.user.controllers.dtos.FindUserByIdResponse;
import com.example.ecommerce.user.domains.User;
import com.example.ecommerce.user.usecases.CreateUser;
import com.example.ecommerce.user.usecases.FindUserById;
import com.github.f4b6a3.ulid.Ulid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final CreateUser createUser;
    private final FindUserById findUserById;

    @PostMapping
    public ResponseEntity<CreateUserResponse> create(final @RequestBody CreateUserRequest request) {
        final User user = createUser.execute(request.toDomain());
        return ResponseEntity.status(HttpStatus.CREATED).body(CreateUserResponse.fromDomain(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FindUserByIdResponse> findById(final @PathVariable("id") UUID id) {
        final User user = findUserById.execute(id);
        return ResponseEntity.ok(FindUserByIdResponse.fromDomain(user));
    }
}
