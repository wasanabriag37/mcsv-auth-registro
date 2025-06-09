package com.nuevaeps.auth.infrastruture.adapters;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nuevaeps.auth.domain.exceptions.ExceptionAuthUser;
import com.nuevaeps.auth.domain.ports.out.LoginUseCaseOutput;
import com.nuevaeps.auth.infrastruture.input.models.LoginRequest;
import com.nuevaeps.auth.infrastruture.input.models.LoginResponse;
import com.nuevaeps.auth.infrastruture.jwt_token.jwt_port.JwtToken;
import com.nuevaeps.auth.infrastruture.mappers.LoginUserMapperInf;
import com.nuevaeps.auth.infrastruture.output.persistence.entities.UserEntity;
import com.nuevaeps.auth.infrastruture.output.persistence.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginAdapter implements LoginUseCaseOutput{

    private final UserRepository userRepository;
    private final JwtToken jwtToken;
    private final LoginUserMapperInf loginUserMapperInf;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    
    @Override
    public LoginResponse auth(LoginRequest loginRequest) {
        UserEntity userEntity = userRepository.findByEmail(loginRequest.getEmail());
        if (!passwordEncoder.matches(loginRequest.getPassword(), userEntity.getPassword())) throw new ExceptionAuthUser("Contraseña incorrecta");
        return loginUserMapperInf.buildLoginResponse("Acceso completado", jwtToken.generateToken(loginUserMapperInf.userEntityToUserDto(userEntity)), true);
    }

    @Override
    public boolean validateActive(String email) {
        return userRepository.existsByEmailAndActiveTrue(email);
    }


}
