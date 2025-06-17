package com.example.ecs_fargate_demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class LoginResponse {
    private String token;
    private String username;
    private String email;
    private List<String> roles;
    private String tokenType;

    public LoginResponse(String token, String username, String email, List<String> roles) {
        this.token = token;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.tokenType = "Bearer";
    }
} 