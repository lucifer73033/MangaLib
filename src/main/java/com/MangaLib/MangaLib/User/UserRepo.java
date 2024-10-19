package com.MangaLib.MangaLib.User;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepo extends MongoRepository<LibUser,String> {
    public List<String> findRolesById(String id);

}
