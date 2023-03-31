package com.workshop.kartaca.controller;

import com.workshop.kartaca.dto.request.LoginRequest;
import com.workshop.kartaca.dto.request.RegisterRequest;
import com.workshop.kartaca.dto.response.LoginResponse;
import com.workshop.kartaca.dto.response.RegisterResponse;
import com.workshop.kartaca.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request
    ) {
        return ResponseEntity.ok(service.login(request));
    }


}