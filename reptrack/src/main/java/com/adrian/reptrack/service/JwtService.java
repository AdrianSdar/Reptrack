package com.adrian.reptrack.service;

import java.util.Date;
import org.springframework.stereotype.Service;
import com.adrian.reptrack.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Service
public class JwtService{
    
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor("din-hemliga-nyckel-som-måste-vara-minst-32-tecken".getBytes(StandardCharsets.UTF_8));

    public String generateToken(User user){
        return Jwts.builder().subject(user.getEmail()).issuedAt(new Date()).expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)).signWith(SECRET_KEY).compact();
    }
}