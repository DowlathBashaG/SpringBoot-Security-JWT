package io.dowlath.springbootjwtsecurity.security;

import io.dowlath.springbootjwtsecurity.model.JwtAuthenticationToken;
import io.dowlath.springbootjwtsecurity.model.JwtUser;
import io.dowlath.springbootjwtsecurity.model.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Dowlath
 * @create 7/9/2020 3:31 PM
 */
@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {


    @Autowired
    private JwtValidator validator;
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String s, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken)usernamePasswordAuthenticationToken;
        String token = jwtAuthenticationToken.getToken();
        JwtUser jwtUser = validator.validate(token);

        if(jwtUser == null){
            throw new RuntimeException("JWT Token is incorrect");
        }

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(jwtUser.getRole());

        return new JwtUserDetails(jwtUser.getUserName(),jwtUser.getId(),token,grantedAuthorities);

    }

    @Override
    public boolean supports(Class<?> aClass) {

        return (JwtAuthenticationToken.class.isAssignableFrom(aClass));
    }
}
