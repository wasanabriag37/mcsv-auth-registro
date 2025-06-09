package com.nuevaeps.auth.infrastruture.input.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nuevaeps.auth.application.input.LoginUseCase;
import com.nuevaeps.auth.application.input.RegisterUseCase;
import com.nuevaeps.auth.infrastruture.input.models.LoginRequest;
import com.nuevaeps.auth.infrastruture.input.models.LoginResponse;
import com.nuevaeps.auth.infrastruture.input.models.RegisterRequest;
import com.nuevaeps.auth.infrastruture.input.models.RegisterResponse;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
// @CrossOrigin(origins = "http://localhost:8080/**")
public class ControllerAuthRegister {

    private final LoginUseCase loginUseCase;
    private final RegisterUseCase registerUseCase;

    @Operation(
            summary = "Autenticacion",
            description = "Autenticacion"
    )
    @PostMapping(
            value = "/login"
    )
    public LoginResponse auth(@RequestBody @Valid LoginRequest request) {
        return loginUseCase.auth(request);
    }


    @Operation(
            summary = "Registro",
            description = "Registro"
    )
    @PostMapping(
            value = "/register"
    )
    public RegisterResponse register(@RequestBody @Valid RegisterRequest request) {
        return registerUseCase.register(request);
    }
}
