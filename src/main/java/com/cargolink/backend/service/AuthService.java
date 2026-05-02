package com.cargolink.backend.service;

import com.cargolink.backend.dto.LoginRequest;
import com.cargolink.backend.dto.SignUpRequest;
import com.cargolink.backend.entity.User;
import com.cargolink.backend.repository.UserRepository;
import com.cargolink.backend.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(SignUpRequest request) {
        User user = new User();
        user.setName(request.name);
        user.setPhone(request.phone);
        user.setPassword(passwordEncoder.encode(request.password));
        user.setRole("USER");
        user.setIsVerified(false);
        user.setRating(0.0);

        return userRepository.save(user);
    }

    public String login(LoginRequest request) {
    User user = userRepository.findByPhone(request.phone)
            .orElseThrow(() -> new RuntimeException("User not found"));

    if (!passwordEncoder.matches(request.password, user.getPassword())) {
        throw new RuntimeException("Invalid credentials");
    }

    return JwtUtil.generateToken(user.getPhone()); // ✅ JWT returned
}
}
