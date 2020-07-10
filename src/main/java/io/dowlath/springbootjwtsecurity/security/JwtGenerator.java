package io.dowlath.springbootjwtsecurity.security;

import io.dowlath.springbootjwtsecurity.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

/**
 * @Author Dowlath
 * @create 7/10/2020 6:49 PM
 */
@Component
public class JwtGenerator {

    public String generate(JwtUser jwtUser) {
        Claims claims = Jwts.claims()
                        .setSubject(jwtUser.getUserName());
        claims.put("userId",String.valueOf(jwtUser.getId()));
        claims.put("role",jwtUser.getRole());


        return  Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512,"youtube")
                .compact();

    }
}
