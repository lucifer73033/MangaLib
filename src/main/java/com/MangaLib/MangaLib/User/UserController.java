package com.MangaLib.MangaLib.User;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    ResponseEntity<?> saveUser(@RequestParam String username){
        userService.login(username);
        return ResponseEntity.status(200).body("OK");
    }
    @PostMapping("/roles")
    ResponseEntity<?> getRoles(@RequestParam String username){
       return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.getRoles(username));
    }
    @GetMapping("/hello")
    String hello(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
