package com.nuevaeps.auth.domain.ports.in;

import com.nuevaeps.auth.infrastruture.input.models.LoginRequest;
import com.nuevaeps.auth.infrastruture.input.models.LoginResponse;

public interface AuthUserIn {
    LoginResponse auth(LoginRequest loginRequest);
}
