package com.nuevaeps.auth.domain.exceptions;

public class ExceptionUserFound extends RuntimeException {
    public ExceptionUserFound(String message) {
        super("El usuario ya existe en los registros");
    }
}
