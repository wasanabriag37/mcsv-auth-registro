package com.nuevaeps.auth.domain.ports.out;

import com.nuevaeps.auth.domain.models.UserRegister;
import com.nuevaeps.auth.infrastruture.input.models.RegisterResponse;

public interface RegisterUseCaseOutput {
    RegisterResponse register(UserRegister userRegister);
    boolean findByEmail(String email);
}
