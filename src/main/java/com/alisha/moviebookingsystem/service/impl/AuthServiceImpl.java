package com.alisha.moviebookingsystem.service.impl;

import com.alisha.moviebookingsystem.dto.request.LoginRequest;
import com.alisha.moviebookingsystem.dto.request.RegisterRequest;
import com.alisha.moviebookingsystem.dto.response.AuthResponse;
import com.alisha.moviebookingsystem.entity.User;
import com.alisha.moviebookingsystem.enums.RoleType;
import com.alisha.moviebookingsystem.exception.DuplicateResourceException;
import com.alisha.moviebookingsystem.repository.UserRepository;
import com.alisha.moviebookingsystem.security.JwtService;
import com.alisha.moviebookingsystem.service.interfaces.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new DuplicateResourceException("Email already registered");
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(RoleType.CUSTOMER)
                .build();

        userRepository.save(user);

        String token = jwtService.generateToken(user.getEmail());

        return new AuthResponse(token);
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        String token = jwtService.generateToken(request.getEmail());

        return new AuthResponse(token);
    }
}