package com.nuevaeps.auth.infrastruture.jwt_token.services;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nuevaeps.auth.domain.models.User;
import com.nuevaeps.auth.infrastruture.jwt_token.jwt_port.JwtToken;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService implements JwtToken  {

    @Value("${jwt.secret.key}")
    private String secretKey;

    private static final long EXPIRATION_TIME = 10L * 60L * 10000L;

    @Override
    public String generateToken(User user) {
        return Jwts.builder()
                .claim("user", user)
                .subject(user.getEmail())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSignatureKey())
                .compact();
    }

    public Key getSignatureKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
