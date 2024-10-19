package com.MangaLib.MangaLib.User;

import org.springframework.data.annotation.Id;

import java.util.List;

public class LibUser {
    @Id
    String id;
    List<String> roles;

    public LibUser(String id, List<String> roles) {
        this.id = id;
        this.roles = roles;
    }


    public void setSub(String id) {
        this.id = id;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
