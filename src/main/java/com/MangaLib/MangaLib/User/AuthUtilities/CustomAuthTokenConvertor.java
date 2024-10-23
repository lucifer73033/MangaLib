package com.MangaLib.MangaLib.User.AuthUtilities;

import com.MangaLib.MangaLib.User.POJOs.LibUser;
import com.MangaLib.MangaLib.User.UserRepo;
//import jdk.incubator.vector.VectorOperators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomAuthTokenConvertor implements Converter<Jwt,CustomJwtAuthToken>{
    @Autowired
    private UserRepo userRepo;
    @Override
    public CustomJwtAuthToken convert(Jwt source) {
        String sub=(String)source.getClaims().get("sub");
        if(userRepo.existsById(sub)) {
            System.out.println("bababooey");
            List<GrantedAuthority> roles = userRepo.findRolesById(sub).stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
            return new CustomJwtAuthToken(source, roles);
        }
        else{
            userRepo.save(new LibUser(sub,List.of("READ")));
            return new CustomJwtAuthToken(source,List.of(()->"READ"));
        }
    }
}
