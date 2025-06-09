package com.nuevaeps.auth.application.services;

import org.springframework.stereotype.Service;

import com.nuevaeps.auth.application.input.RegisterUseCase;
import com.nuevaeps.auth.application.mappers.RegisterUserMapper;
import com.nuevaeps.auth.domain.ports.in.RegisterUserIn;
import com.nuevaeps.auth.infrastruture.input.models.RegisterRequest;
import com.nuevaeps.auth.infrastruture.input.models.RegisterResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterService implements RegisterUseCase {
    
    private final RegisterUserMapper registerUserMapper;
    private final RegisterUserIn registerUserIn;
    
    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
       return registerUserIn.registerUser(registerUserMapper.dtoRegisterRequestToUserRegister(registerRequest));
    }
    
}
