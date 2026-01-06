package com.fabpont.dev.sebo_virtual.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fabpont.dev.sebo_virtual.entities.User;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Component
public class TokenConfig {

    private String secret = "secret";

    public String generateToken(User user) {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withClaim("userId", user.getId())
                .withSubject(user.getEmail())
                .withExpiresAt(Instant.now().plus(Duration.ofDays(365)))
                .withIssuedAt(Instant.now())
                .sign(algorithm);

    }
}
