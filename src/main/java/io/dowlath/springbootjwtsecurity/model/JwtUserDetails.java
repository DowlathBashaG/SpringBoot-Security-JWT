package io.dowlath.springbootjwtsecurity.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @Author Dowlath
 * @create 7/10/2020 4:56 PM
 */
public class JwtUserDetails implements UserDetails {

    private String userName;
    private String token;
    private Long id;
    private Collection<? extends GrantedAuthority> authorities;
    public JwtUserDetails(String userName, long id, String token, List<GrantedAuthority> grantedAuthorityList){
        this.userName = userName;
        this.id = id;
        this.authorities = grantedAuthorityList;
        this.token = token;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword(){
        return null;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getUserName() {
        return userName;
    }


    public String getToken() {
        return token;
    }

    public Long getId() {
        return id;
    }
}
