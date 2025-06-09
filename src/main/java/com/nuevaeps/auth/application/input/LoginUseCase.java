package com.nuevaeps.auth.application.input;

import com.nuevaeps.auth.infrastruture.input.models.LoginRequest;
import com.nuevaeps.auth.infrastruture.input.models.LoginResponse;

public interface LoginUseCase {
    LoginResponse auth(LoginRequest loginRequest);
}
