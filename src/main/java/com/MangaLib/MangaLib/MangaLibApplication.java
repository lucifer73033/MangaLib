package com.MangaLib.MangaLib;

import com.MangaLib.MangaLib.User.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//TODO 1)Implement User funct
// ioanality using SS and Spring
// Data Mongo
// 2)Do HTTP Basic Login
@SpringBootApplication
public class MangaLibApplication {
	@Autowired
	private UserRepo userRepo;

	public static void main(String[] args) {

		SpringApplication.run(MangaLibApplication.class, args);
	}

}
