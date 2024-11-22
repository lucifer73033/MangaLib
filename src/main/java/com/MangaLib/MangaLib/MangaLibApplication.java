package com.MangaLib.MangaLib;

import com.MangaLib.MangaLib.User.UserRepo;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// Done 1)Implement User funct
// 		ioanality using SS and Spring
// 		Data Mongo
// Done 2)Do HTTP Basic Login
// Done 3)Test JWT
// Done 4)check mangadex endpoints
// Done 7)Rate Limiting
//TODO
// Implement
// 5)Implement showing data to the front end
// 6)Implement User Data Management
// 8)Caching


//TODO
// Learn
// ! Read up the MongoObjectMapper
//   Documentation
// ! Caching
// ! Batching API Request and
//   pagination
// ! Threading and its applica
//   tions here
@SpringBootApplication
public class MangaLibApplication {


	public static void main(String[] args) {

		SpringApplication.run(MangaLibApplication.class, args);

	}

}
