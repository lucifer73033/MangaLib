package com.MangaLib.MangaLib.User;

import com.MangaLib.MangaLib.User.POJOs.LibUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepo extends MongoRepository<LibUser,String> {
    public List<String> findRolesById(String id);

}
