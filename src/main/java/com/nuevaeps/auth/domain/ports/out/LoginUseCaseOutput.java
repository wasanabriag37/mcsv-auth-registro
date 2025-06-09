package com.nuevaeps.auth.domain.ports.out;

import com.nuevaeps.auth.infrastruture.input.models.LoginRequest;
import com.nuevaeps.auth.infrastruture.input.models.LoginResponse;

public interface LoginUseCaseOutput {
     LoginResponse auth(LoginRequest loginRequest);
     boolean validateActive(String email);
}
