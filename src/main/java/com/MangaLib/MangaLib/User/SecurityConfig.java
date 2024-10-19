package com.MangaLib.MangaLib.User;

import com.MangaLib.MangaLib.User.AuthToken.CustomAuthTokenConvertor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.validation.annotation.Validated;

@Configuration
public class SecurityConfig {
    @Value("${URI}")
    private String jwksURI;
    @Autowired
    private CustomAuthTokenConvertor convertor;
    @Autowired
    private CustomBasicAuthProvider customBasicAuthProvider;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        return http
                .authorizeHttpRequests(c->c.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .authenticationProvider(customBasicAuthProvider)
                .oauth2ResourceServer(oauth->oauth.jwt(j->j.jwkSetUri(jwksURI).jwtAuthenticationConverter(convertor)))
                .csrf(c->c.disable())
                .build();
    }
}
