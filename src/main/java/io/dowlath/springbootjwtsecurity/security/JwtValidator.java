package io.dowlath.springbootjwtsecurity.security;

import io.dowlath.springbootjwtsecurity.model.JwtUser;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
/**
 * @Author Dowlath
 * @create 7/10/2020 2:37 PM
 */
@Component
public class JwtValidator {

    private String secret = "youtube"; // hot coded value  , you have to create and parse the value.

    public JwtUser validate(String token) {

        JwtUser jwtUser = null;

        try {
            Claims body = Jwts.parser().setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser = new JwtUser();

            jwtUser.setUserName(body.getSubject());
            jwtUser.setId(Long.parseLong((String) body.get("userId")));
            jwtUser.setRole((String) body.get("role"));

           }
        catch(Exception e){
            System.out.println(e);
        }

        return jwtUser;

    }
}
