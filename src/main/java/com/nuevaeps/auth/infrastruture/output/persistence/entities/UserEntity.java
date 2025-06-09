package com.nuevaeps.auth.infrastruture.output.persistence.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Tab_users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId;

    @Column(name = "numberDocument")
    private Long numberDocument;

    @Column(name = "names")
    private String names;
    
    @Column(name = "lastNames")
    private String lastNames;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "active")
    private boolean active;

    @Column(name = "password")
    private String password;

    @Column(name = "createdAt", nullable = false, updatable = false)
    @CreationTimestamp
    private java.sql.Timestamp createdAt;

    @Column(name = "updatedAt", nullable = false)
    @UpdateTimestamp
    private java.sql.Timestamp updatedAt;
}
