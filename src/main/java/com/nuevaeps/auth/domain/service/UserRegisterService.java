package com.nuevaeps.auth.domain.service;

import org.springframework.stereotype.Service;

import com.nuevaeps.auth.domain.exceptions.ExceptionUserExist;
import com.nuevaeps.auth.domain.models.UserRegister;
import com.nuevaeps.auth.domain.ports.in.RegisterUserIn;
import com.nuevaeps.auth.domain.ports.out.RegisterUseCaseOutput;
import com.nuevaeps.auth.domain.rules.PasswordValidatorRule;
import com.nuevaeps.auth.infrastruture.input.models.RegisterResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserRegisterService implements RegisterUserIn{

    private final RegisterUseCaseOutput registerUseCaseOutput;
    private final PasswordValidatorRule passwordValidatorRule;

    @Override
    public RegisterResponse registerUser(UserRegister userRegister) {
        if(registerUseCaseOutput.findByEmail(userRegister.getEmail())) throw new ExceptionUserExist();
        userRegister.setPassword(passwordValidatorRule.encodePassword(userRegister.getPassword()));
        userRegister.setActive(true);
        return registerUseCaseOutput.register(userRegister);
    }
}
