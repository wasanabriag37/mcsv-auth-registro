package com.nuevaeps.auth.infrastruture.input.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "Los nombres deben ser completado")
    private String names;
    @NotBlank(message = "Los apellidos debe ser completado")
    private String lastNames;
    @NotNull(message = "El numero de documento debe ser completado")
    private Long numberDocument;
    @NotBlank(message = "El correo debe ser completado")
    private String email;
    private String phone;
    @NotNull(message = "La contraseña debe ser completada")
    private String password;
}
