package com.nuevaeps.auth.infrastruture.jwt_token.jwt_port;

import com.nuevaeps.auth.domain.models.User;

public interface JwtToken {
    String generateToken(User user);
}
