package com.alisha.moviebookingsystem.service.interfaces;

import com.alisha.moviebookingsystem.dto.request.LoginRequest;
import com.alisha.moviebookingsystem.dto.request.RegisterRequest;
import com.alisha.moviebookingsystem.dto.response.AuthResponse;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}