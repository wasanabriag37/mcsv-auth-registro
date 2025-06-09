package com.nuevaeps.auth.application.input;

import com.nuevaeps.auth.infrastruture.input.models.RegisterRequest;
import com.nuevaeps.auth.infrastruture.input.models.RegisterResponse;

public interface RegisterUseCase {
    RegisterResponse register(RegisterRequest registerRequest);
}
