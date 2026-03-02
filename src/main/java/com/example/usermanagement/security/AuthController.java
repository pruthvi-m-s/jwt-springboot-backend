package com.example.usermanagement.security;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.usermanagement.dto.LoginRequestDTO;
import com.example.usermanagement.dto.UserRequestDTO;
import com.example.usermanagement.entity.User;
import com.example.usermanagement.repository.UserRepository;
import com.example.usermanagement.security.CustomUserDetails;
import com.example.usermanagement.security.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    public AuthController(UserRepository userRepo, PasswordEncoder passwordEncoder,
                          AuthenticationManager authManager, JwtUtil jwtUtil) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserRequestDTO dto) {
        if (userRepo.findByUsername(dto.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        User user = new User(
                dto.getUsername(),
                passwordEncoder.encode(dto.getPassword()),
                dto.getRole(),
                dto.getName(),
                dto.getAge()
        );

        userRepo.save(user);

        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDTO dto) {
    try {
        authManager.authenticate(
            new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
        );

        CustomUserDetails userDetails = (CustomUserDetails) userRepo
                .findByUsername(dto.getUsername())
                .map(CustomUserDetails::new)
                .orElseThrow();

        String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(token);
    } catch (AuthenticationException e) {
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}
}