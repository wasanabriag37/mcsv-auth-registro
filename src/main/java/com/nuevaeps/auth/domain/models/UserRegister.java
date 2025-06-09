package com.nuevaeps.auth.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRegister {
    private String names;
    private String lastNames;
    private Long numberDocument;
    private String email;
    private String phone;
    private String password;
    private boolean active;

}
