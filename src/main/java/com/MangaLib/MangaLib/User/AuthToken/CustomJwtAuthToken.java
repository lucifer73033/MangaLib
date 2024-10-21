package com.MangaLib.MangaLib.User.AuthToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.List;
import java.util.logging.Logger;

public class CustomJwtAuthToken extends JwtAuthenticationToken {
//    private List<? extends GrantedAuthority> roles;
    public CustomJwtAuthToken(Jwt jwt,List<? extends GrantedAuthority> roles) {
        super(jwt,roles);
        System.out.println("bababoeey2");
    }
}
