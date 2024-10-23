package com.MangaLib.MangaLib;

import com.MangaLib.MangaLib.User.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//TODO
// Implement
// Done 1)Implement User funct
// 		ioanality using SS and Spring
// 		Data Mongo
// Done 2)Do HTTP Basic Login
// Done 3)Test JWT
// Done 4)check mangadex endpoints
// 5)Implement showing data to the front end of the

//TODO
// Learn
// 1)Oauth Client
// 2)Rate Limiting
// 3)Caching
// 4)Batching API Request and
//   pagination
// 5)Threading and its applica
//   tions here
@SpringBootApplication
public class MangaLibApplication {
	@Autowired
	private UserRepo userRepo;

	public static void main(String[] args) {

		SpringApplication.run(MangaLibApplication.class, args);
	}

}
