package com.MangaLib.MangaLib.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public void login(String username){
        userRepo.save(new LibUser(username, List.of("READ")));
    }
    public List<String> getRoles(String username){
        return userRepo.findRolesById(username);
    }
}
