package com.example.ecs_fargate_demo.controller;

import com.example.ecs_fargate_demo.dto.LoginRequest;
import com.example.ecs_fargate_demo.dto.LoginResponse;
import com.example.ecs_fargate_demo.dto.RegisterRequest;
import com.example.ecs_fargate_demo.entity.User;
import com.example.ecs_fargate_demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        try {
            LoginResponse response = authService.login(loginRequest);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest registerRequest) {
        try {
            User user = authService.register(registerRequest);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/register/editor")
    public ResponseEntity<User> registerEditor(@RequestBody RegisterRequest registerRequest) {
        try {
            User user = authService.createEditor(registerRequest);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
} 