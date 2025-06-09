package com.nuevaeps.auth.domain.service;

import org.springframework.stereotype.Service;

import com.nuevaeps.auth.domain.ports.in.AuthUserIn;
import com.nuevaeps.auth.domain.ports.out.LoginUseCaseOutput;
import com.nuevaeps.auth.domain.rules.AuthValidatorsRules;
import com.nuevaeps.auth.infrastruture.input.models.LoginRequest;
import com.nuevaeps.auth.infrastruture.input.models.LoginResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserAuthService implements AuthUserIn {

    private final LoginUseCaseOutput loginUseCaseOutput;
    private final AuthValidatorsRules authValidatorsRules;

    @Override
    public LoginResponse auth(LoginRequest loginRequest) {
        authValidatorsRules.authValidator(loginRequest);
        return loginUseCaseOutput.auth(loginRequest);
    }

}
