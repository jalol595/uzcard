package com.example.uzcard.util;



import com.example.uzcard.dto.JwtDTO;
import com.example.uzcard.exseptions.BadRequestException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {
    private static final String secretKey = "Sekratniy_kalit";

    public static String encode(String id) {
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setIssuedAt(new Date()); // 18:58:00
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + (60 * 60 * 60 * 1000))); // 19:58:00
        jwtBuilder.setIssuer("Mazgi production");
        jwtBuilder.signWith(SignatureAlgorithm.HS256, secretKey);
        jwtBuilder.claim("id", id);
        return jwtBuilder.compact();
    }

    public static String encode(JwtDTO dto) {
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setIssuedAt(new Date()); // 18:58:00
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + (60 * 60 * 60 * 1000))); // 19:58:00
        jwtBuilder.setIssuer("Mazgi production");
        jwtBuilder.signWith(SignatureAlgorithm.HS256, secretKey);
        jwtBuilder.claim("id", dto.getId());
        jwtBuilder.claim("role", dto.getRole());
        return jwtBuilder.compact();
    }

    public static String decode(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
        return (String) claims.get("id");
    }

    public static JwtDTO decodeJwtDTO(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
        JwtDTO dto = new JwtDTO();
        dto.setId((String) claims.get("id"));
        dto.setRole((String) claims.get("role"));
        return dto;
    }

}

