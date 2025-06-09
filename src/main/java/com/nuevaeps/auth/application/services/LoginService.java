package com.nuevaeps.auth.application.services;

import org.springframework.stereotype.Service;

import com.nuevaeps.auth.application.input.LoginUseCase;
import com.nuevaeps.auth.domain.ports.in.AuthUserIn;
import com.nuevaeps.auth.infrastruture.input.models.LoginRequest;
import com.nuevaeps.auth.infrastruture.input.models.LoginResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService implements LoginUseCase {
    
    private final AuthUserIn authUserIn;

    @Override
    public LoginResponse auth(LoginRequest loginRequest) {
        return authUserIn.auth(loginRequest);
    }

}
