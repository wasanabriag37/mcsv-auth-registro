package com.nuevaeps.auth.domain.rules;

import org.springframework.stereotype.Service;

import com.nuevaeps.auth.domain.exceptions.ExceptionAuthUser;
import com.nuevaeps.auth.domain.ports.out.LoginUseCaseOutput;
import com.nuevaeps.auth.infrastruture.input.models.LoginRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthValidatorsRules {

    private final LoginUseCaseOutput loginUseCaseOutput;

    public void authValidator(LoginRequest loginRequest){
        if(loginRequest.getEmail()==null) throw new ExceptionAuthUser("Ingrese el correo");
        if(loginRequest.getPassword()== null) throw new ExceptionAuthUser("Ingrese la constraseña");
        if(!loginUseCaseOutput.validateActive(loginRequest.getEmail())) throw new ExceptionAuthUser("Usuario inactivo");
    }
}
