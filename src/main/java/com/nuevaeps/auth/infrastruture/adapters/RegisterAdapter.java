package com.nuevaeps.auth.infrastruture.adapters;


import org.springframework.stereotype.Service;

import com.nuevaeps.auth.domain.models.UserRegister;
import com.nuevaeps.auth.domain.ports.out.RegisterUseCaseOutput;
import com.nuevaeps.auth.infrastruture.input.models.RegisterResponse;
import com.nuevaeps.auth.infrastruture.mappers.RegisterUserMapperInf;
import com.nuevaeps.auth.infrastruture.output.persistence.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterAdapter implements RegisterUseCaseOutput {
    
    private final UserRepository userRepository;
    private final RegisterUserMapperInf registerUserMapper;

    @Override
    public RegisterResponse register(UserRegister userRegister) {
        return registerUserMapper.userEntityTRegisterResponse(userRepository.save(registerUserMapper.dtoUserRegisterToUserEntity(userRegister)));
    }

    @Override
    public boolean findByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    
}
