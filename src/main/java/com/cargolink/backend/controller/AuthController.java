package com.cargolink.backend.controller;

import com.cargolink.backend.dto.LoginRequest;
import com.cargolink.backend.dto.SignUpRequest;
import com.cargolink.backend.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public String signup(@RequestBody SignUpRequest request) {
        authService.signup(request);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}