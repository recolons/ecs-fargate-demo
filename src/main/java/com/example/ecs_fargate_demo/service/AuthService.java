package com.example.ecs_fargate_demo.service;

import com.example.ecs_fargate_demo.dto.LoginRequest;
import com.example.ecs_fargate_demo.dto.LoginResponse;
import com.example.ecs_fargate_demo.dto.RegisterRequest;
import com.example.ecs_fargate_demo.entity.Role;
import com.example.ecs_fargate_demo.entity.User;
import com.example.ecs_fargate_demo.repository.RoleRepository;
import com.example.ecs_fargate_demo.repository.UserRepository;
import com.example.ecs_fargate_demo.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider tokenProvider;

    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);

        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<String> roles = user.getAuthorities().stream()
                .map(authority -> authority.getAuthority().replace("ROLE_", ""))
                .collect(Collectors.toList());

        return new LoginResponse(jwt, user.getUsername(), user.getEmail(), roles);
    }

    public User register(RegisterRequest registerRequest) {
        if (userRepository.existsByUsername(registerRequest.getUsername())) {
            throw new RuntimeException("Username is already taken!");
        }

        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            throw new RuntimeException("Email is already in use!");
        }

        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setEmail(registerRequest.getEmail());
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());

        // Set default role as USER
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(Role.RoleType.USER)
                .orElseThrow(() -> new RuntimeException("Default role not found"));
        roles.add(userRole);
        user.setRoles(roles);

        return userRepository.save(user);
    }

    public User createEditor(RegisterRequest registerRequest) {
        if (userRepository.existsByUsername(registerRequest.getUsername())) {
            throw new RuntimeException("Username is already taken!");
        }

        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            throw new RuntimeException("Email is already in use!");
        }

        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setEmail(registerRequest.getEmail());
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());

        // Set role as EDITOR
        Set<Role> roles = new HashSet<>();
        Role editorRole = roleRepository.findByName(Role.RoleType.EDITOR)
                .orElseThrow(() -> new RuntimeException("Editor role not found"));
        roles.add(editorRole);
        user.setRoles(roles);

        return userRepository.save(user);
    }
} 