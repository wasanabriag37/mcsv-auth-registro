package com.nuevaeps.auth.domain.ports.in;

import com.nuevaeps.auth.domain.models.UserRegister;
import com.nuevaeps.auth.infrastruture.input.models.RegisterResponse;

public interface RegisterUserIn {
    RegisterResponse registerUser(UserRegister userRegister);
}
