package com.nuevaeps.auth.infrastruture.input.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUser {
    private int userId;
    private Long numberDocument;
    private String names;
    private String lastNames;
    private String email;
    private String phone;
    private boolean active;
    private java.sql.Timestamp createdAt;
    private java.sql.Timestamp updatedAt;
}
