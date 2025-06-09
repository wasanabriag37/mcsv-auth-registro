package com.nuevaeps.auth.domain.exceptions;

public class ExceptionUserExist extends RuntimeException {
    public ExceptionUserExist() {
        super("El usuario ya existe en los registros");
    }
}