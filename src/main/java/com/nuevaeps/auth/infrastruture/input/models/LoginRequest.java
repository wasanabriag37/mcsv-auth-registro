package com.nuevaeps.auth.infrastruture.input.models;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginRequest {
    @NotNull(message = "El correo es obligatorio")
    private String email;
    @NotNull(message = "El password es obligatorio")
    private String password;
}
